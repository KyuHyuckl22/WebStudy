<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	1. JSP 동작 구조
		사용자 (클라이언트) : 브라우저 => 서버로 요청 => 파일 요청
								========
								URL 주소 이용 => 마지막에 파일 첨부
					http://localhost/JSPBasicProject_6/jsp/basic_1.jsp
														   ============
														   => 확장자 변경이 가능
		서버 : 톰캣 => 요청을 받아서 (자바) => 요청처리 => HTML을 브라우저로전송
		
		브라우저 : URL 전송 ================================> DNS
			  http://localhost							 IP변환 127.0.0.1
			  http://www.daum.net							   211.249.220.24
			  												   ================
			  												   socek을 이용해서 서버에 연결
			  											  |
			  											  └ 서버 연결
			  											  	======
			  											  = HTML / XML /JSON => 서버에서 단독 처리
			  											  = JSP / SERVLET
			  											  ================
			  											        |
			  											      Tomcat (WAS) => Wep Application Server
			  											        |
			  											       자바 번역 => HTML 변환
			  											                =========
			  											                메모리를 브라우저에서 일겅서
			  											                출력할 수 있게 보내준다
			  									자바 번역
			  									======
			  									JSP 파일을 => 클래스화
			  									a.jsp ========> class a_jsp extends HttpJspBase
			  									=====			{	 <%! 메소드, 멤버변수 %> 선언식
			  									 소스					public void _jspInit(){}
			  									=====				public void _jspDestory(){}
			  									 					public void _jspService(){
			  									 						JSP 에서 작성한 소스
			  									 						<%  %>
			  									 						<%= %>
			  									 						HTML은 out.write("<html>")
			  									 					}
			  									 	  			}
			  									1) 클래스 만들기 => 한번만 만든다 => 변경 => 만들어진 클래스 수정
			  									2) 컴파일 => .class
			  									3) .class 를 한 줄씩 읽어서 out.write() => 메모리에 저장
			  																		 ==========
			  																		  buffer : 임시 저장소
			  																		 (사용자 한명당 1개만 생성)
			  									4) 메모리에 출력된 내용을 브라우저에서 읽어서 출력
			  									=> tomcat / regin / 웹로직 / 웹스피어 / 제우스
			  									  ========						 ======
			  									       |                            |
			  									       ==============================
			  									       			    WAS									  
	2. 실행순서	
		1) JSP
		2) 사용자 요청 => JSP 파일 요청
		3) 톰캣 => 클래스로 변경
		4) 클래스 => 컴파일 .class
		5) .class 를 읽기 시작
			= _jspInit() => 환경설정, 멤버변수 초기화
							================= web.xml
			= _jspServiec()
			= _jspDestroy()
			= 서버
			  서버 연결 => 통신을 할 수 있게 쓰레드를 생성
			  ======= 클라이언트가 한 개씩 연결
	3. HTML 과 자바 구분
		<%  %> : 일반 자바소스 => 지역변수 선언, 연산자, 제어문, 메소드 호출
				 문법 사항이 자바와 동일
				 문장 종료   ;
				 주석 처리   // , /**/ 
		<%= %> 
		<%! %> 
	4. 지시자 (5장)
		= page
			: JSP파일에 대한 정보
			  1) contentType => 브라우저에 어떤 형식인지 알려준다
			  	 HTML / XML / JSON
			  	 => HTML => text/html;charset=UTF-8
			  	 	XML  => text/xml;charset=UTF-8
			  	 	JSON => text/plain;charset=UTF-8
			  	 	=======> List, VO
			  2) import => 라이브러리 / 사용자 정의 클래스
			   => 다른 속성은 1 번만 사용이 가능
			   => import 는 여러번 사용이 가능
			   	<%@ page import="java.util.*,java.io.*;"%>
			   	<%@ page import="java.util.*" %>
			   	<%@ page import="java.io.*"%>
			  3) errorPage : error 시에 error 파일을 만들어서 보여주는 역할
			  	404 : 파일이 없는 경우
			  	500 : 컴파일시 에러 => 자바에서 오류 발생
			  	405 : GET / POST 가 틀린 경우
			  	412 : bad request : 데이터를 잘못 보낸 경우
			  		ex) int 를 보냈는데 boolean 으로 받은 경우
			  			JSP 에서는 없다 / 스프링에서 많음
			  	403 : 접근거부
			  	200 : 
		= include : 소스를 통합한 후 컴파일
			=? 메누 / Footer
			<%@ include file=""%>
			JSP 안에 특정 부분에 다른 JSP 를 포함 => 조합식
		= taglib => 20장
		 	*** <%@ 지시자 속성="값" %> => "" 를 반드시 사용한다
	5. 액션 태그 (6장) 151p
		1) <jsp:>
			*** <jsp:include> : 스프링에서도 사용 => tiles (사라졌다)
			    => JSP 안에 다른 JSP 연결 => 동적이다
			        => 파일을 컴파일 후에 => 결과(HTML) => HTML 을 묶어주는 역할
			==================================
			<jsp:useBean> : 객체 메모리 할당
				BoardDAO dao=new BoardDAO()
				<jsp:useBean id="dao" class="BoardDAO">
							 ======== =================
							   객체명       
			<jsp:forward>
			  : 화면이동
			  	
			<jsp:setProperty>
			<jsp:getProperty>
	6. 내장 객체 (7장)
	6-1. 데이터 베이스
	7. Cookie
	8. 에러처리
	====================== Basic
	9. EL / JSTL
	10. MVC   ********** 실무 
	====================== Middle 
	11. Spring
	12. Spring-Boot
	====================== Top
	
	 	 public void _jspService(final javax.servlet.http.HttpServletRequest request, 
	  							 HttpServletResponse response)

   		 PageContext pageContext;
   		 HttpSession session = null;
   		 ServletContext application;
   		 ServletConfig config;
   		 JspWriter out = null;
   		 Object page = this;

//       JSP 코딩
   
 --%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>



