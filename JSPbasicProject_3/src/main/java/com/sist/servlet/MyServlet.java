package com.sist.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * http://localhost:8080/JSPbasicProject_3/My.do        확장자는 언제든 바꿀 수 있다
 * http://localhost:8080/JSPbasicProject_3/MyServlet			 |
 * 										  ========== 서블릿은 URL - 파일명 변경이 가능하다
 *  1. URL을 입력하고 웹 서버에 요청
 *  			  =========
 *  			   HTML / XML / JSON => 바로 처리 (브라우저로 전송)
 *  			   Java(Servlet),JSP => WAS(Web Application Server) 를 사용해야함
 *  					|				=========================== Tomcat(자바를 번역해줌)
 *  					|						  a.jsp
 *  					|						1. 클래스로 변경 class a_jsp => a_jsp.java
 *  					|						2. 컴파일  a_jsp.class => 서블릿
 *  				.java =====> 컴파일 .class	
 * 					한 줄씩 번역 ==> 인터프리터 
 * 						|		 1. 서블릿 파일 로딩
 *  					| 		 2. init()
 *  					|		 3. service() => doGet() / doPost()
 *  					|        4. 서블릿이 종료 (새로고침,화면이동) => destory() 호출
 * 					========
 * 					out.write("") => 메모리에 출력
 * 									 ========= 요청한 브라우저에서 읽어서 화면 출력 
 * 					파일 한 개에 데이터 변경이 가능하다 == 동적 페이지
 * 					ex) 페이지가 100 페이지
 * 						==============
 * 						서블릿 / JSP는 한 개의 파일로 제작 => 데이터만 변경
 * 						HTML => 파일을 100개를 만든다 : 정적페이지 (데이터 변경이 안 된다)
 * 		서블릿 (Servlet)
 * 			=> Server + let => 서버에서 실행되는 가벼운 프로그램(경량 프로그램) => 스프링
 * 			=> Server + Applet 
 * 					   ======== Application + let
 * 						└Applet 이 생긴 이후 자바가 발전
 * 						 옛날 웹은 정보 공유가 목적이었다 (1995 이전은 문자로만 출력)
 *                       Applet 이 나오고 이미지 or 애니메이션 이 등장하기 시작 => 2000년 부터 웹이 발전하기 시작
 *          => 웹 서비스 기능을 해주는 자바 클래스
 *            => 자바 안에 JTML 코드를 첨부(JSP => HTML 안에 Java 첨부)
 *            	out.write("<html>") =>  <% 
 *            							%>
 *            							<html>
 *            => 단점
 *              1. HTML 을 사용하기 어렵다(복잡하다) => CSS / JavaScript
 *                out.write("<html>")
 *                out.write("<head>")
 *                out.write("<script type=\"text/javascript\">")
 *                out.write("function aaa(){")
 *                out.write("alert(\"\");")
 *                out.write("</script>")
 *                out.write("</head>")
 *                ... Java 는 문자로 되어있다보니 훨씬 어렵고 복잡하다
 *              2. HTML / CSS / JavaScript 에 대한 에러 처리가 어렵다
 *              3. 확장자 java => 변경시마다 컴파일을 다시 해야한다
 *              	=> 톰캣연결
 *                  => 톰캣 프로젝트
 *                  => AWS => 수정시마다 컴파일 => war => war를 변경해야 한다
 *                     ==========================================
 *                     이런걸 해주는 사람들을 운영 (SE) 라고 한다  
 *                     (SE, SI, SM) 통합 = DevOps => CI / CD 
 * 			  => 장점
 * 				자바 => 배포시에 .class 파일만 전송 => 보안이 뛰어나다
 * 					  ===================== 전체 소스를 볼 수 없다, 다른 사람이 변경 불가능하다.
 * 				주 사용처 : HTML / 자바가 분리된 경우 => 연결 한 역할
 * 						================================ Controller
 * 			  										(스프링은 이미 서블릿 으로 제작되어 있음)                
 *            => 단점을 보완
 *              => 수정과 동시에 확인이 가능하게 만들어 준다 : JSP
 *              => HTML / CSS / JavaScript => 사용이 쉽게 out.write("<html>") 에 들어가는
 *                                                    ===========      ==  이것들을 자동 처리가 되게 만들었다.
 *              => HTML 기반 => 필요한 자바 <% %>, <%= %>
 *              => 실행은 톰캣에 의해 실행
 *              => 보안이 취약하다 (소스 전테를 전송하기 때문)
 *                 ============================  서블릿을 병행
 *                                              ========== 웹과 관련된 라이브러리는 서블릿으로 되어 있다
 *          자바 => SUN => package => javax => tomcat 9
 *                ====
 *                 | 오라클  =>  package => jakarata => tomcat 10 이상
 *                STS 3.9  => jdk11 => 실무 1.8 (호환성이 좋다)
 *                STS 4.x  => jdk 17   
 *                => 전자정부 프레임워크 / ANY 프레임워크
 *                  => 공기업           => 대기업    ==> STS 3.xxx
 *                => 서버 분산 (MSA) => Spring Cloud
 *          서블릿의 실행 과정
 *          ============
 *           URL 주소를 이용해서 전송 => 톰캣
 *           실행 또한 톰캣에 의해서 실행      (java로 치면)
 *           	init()				 main()
 *           	doGet() / doPost()   쓰레드      (클라이언트 마다 따로 동작)
 *           	
 *           	destory()            
 *           	=====================
 *                       
 *
 * 
 */
 
@WebServlet("/MyServlet") // < 어노테이션 (Annotation)
//	 구분자 ( 인덱스와 비슷한 역할 )
/*
 * 1. 웹 분석 순서
 * 	1) web.xml : 시작과 동시에 필요한 데이터를 넘겨준다
 * 	2) server.xml : port 번호 확인 / 파일의 위치가 어디인지 확인하기
 * ======================================================= AWS tomcat
 * 	3) 클래스 분석 => DAO : SQL 분석
 *  4) JSP 분석 : 화면 출력
 */
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

 
	public void init(ServletConfig config) throws ServletException {
//		_japInit() : 초기화 (생성자 역할) => 멤버변수 초기화, 시작과 동시에 처리
//		환경설정 (web.xml) => 등록된 내용을 읽어올때
//		web.xml => 스프링은 라이브러리(이미 만들어져 있음) => 환경설정시 web.xml 등록
//		init() 하는 일 : 서블릿 등록, 보안설정, 에러 설정, 한글 처리 
		System.out.println("MyServlet:init() call");
		String path=config.getInitParameter("file_name");
		System.out.println(path);
		
 	}

 
	
	public void destroy() {
//		종료가 된 상태에서 호출되는 메서드 => 메모리 자동으로 해제
		System.out.println("MyServlet:destroy() call");
 	}
/*
 * 		흐름 : 화면이동	                              게시판을 짤 수 있는가? (CRUD 를 할 수 있는가?)
 * 			======= 
 * 			사용자 요청 => 요청시에 어떤 값을 전송할지              ?키=값&키=값      보통 page요청, 상세보기 요청, 단순 검색 등..
 * 						├ GET  : <a>    URL뒤에 데이터 첨부 ?키=값     GET= 단순한 데이터 (노출되면 안되는 id,pw 는 적합하지 않음)
 * 						└ POST : <form>, Ajax                  POST= 노출이 안 된다 (데이터가 많거나 보안 요구시)
 *  																 로그인, 아이디 찾기, 비밀번호 찾기
 * 			서버 응답  => 요청값을 받아서 오라클에 연결 ...
 * 						request / response
 * 						요청값  	  응답할 경우
 * 								  sendRedirect(), addCookie()
 * 						getParameter()
 * 						getParameterValues()
 * 						=> 한글은 인코딩으로 들어오기 때문에 디코딩 으로 변경해줘야 한다
 * 							setCharEncoding()
 * 					=> 데이터 출력
 * 
 * 		사용자가 데이터 전송 GET  ==> doGet() 호출
 * 		사용자가 데이터 전송 POST ==> doPost() 호출
 * 		통합 : service() 
 * 
 * 		
 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		디폴트 => 메인화면 화면 UI
//		1. 변환=> 브라우저에 알려주는 내용 (HTML,XML,JSON) JSP (page지시자)
		response.setContentType("text/html;charset=UTF-8");
//		response => 1. HTML , 2. Cookie 전송 가능
//		  한 개의 메소드에서 1개만 전송이 가능
//		2. 해당 브라우저(요청된 브라우저)를 찾아서 결과값을 보내준다 
		PrintWriter out = response.getWriter();
//		브라우저에서 HTML을 읽어가는 메모리 공간 => out =>JSP 에서는 내장 객체
		out.write("<html>");
		out.write("<body>");
		out.write("<center>");
		out.write("<h1>Hello servlettttttt</h1>");
		out.write("</center>");
		out.write("</body>");
		out.write("</html>");
		
		out.println("<html>");
		out.println("<body>");
		out.println("<center>");
		out.println("<h1>Hello servlettttttt</h1>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
		
		
	}
/*
 * 		동작
 *  1. 요청 URL 주소로 요청
 *  2. 톰캣이 해당 서블릿 클래스 읽기
 *  3. 메모리 할당
 *  4. 실행 
 *  	init()
 *  	doGet() / doPost()
 *  	destory()
 *  
 *  
 */
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// 		
	}

}
