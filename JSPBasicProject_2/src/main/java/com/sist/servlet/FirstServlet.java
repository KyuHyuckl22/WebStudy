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
 * 	서블릿은 URL로 요청을 하면 tomcat 에 의해실행된다
 * 	==== 순수하게 자바로만 만들어져 있다
 *  ==== http://localhost:8080/JSPBasicProject_2/FirstServlet
 *                                               ============ 맨뒤 파일명과 @webserclet 이 동일하면 그 것을 실행한다.
 *                                               			  대소문자 구분
 *  init() 초기화 => 생성자와 비슷한 역할을 수행.
 *    |
 *  doGet() / doPost()  => 사용자에게 요청 처리에 대한 결과를 보여준다 (HTMl)
 *  ================== 사용자 요청시 한개만 실행 => GET / POST
 *  				   통합 : service()
 *            GET : 화면에 출력 (디폴트) => GET/POST 를 지정하지 않는 경우 => GET을 인식한다
 *            POST : 사용자 요청값을 받아서 처리 
 *    |
 *  destory() 메모리 해제
 *  ========== 1. 새로고침 2. 파일이동
 *   		  => 호출시마다 new / delete 
 *	=> 사용자가 요청한 데이터 전송시
 *         =========== 톰캣에 의해 한군데 모아서 전송 => request
 *          								  ========
 *          									└ 사용자 브라우저 정보를 가지고 있다
 *           										=>IP / PORT
 *	=> 코딩 방식
 *	   1) 변환 코드 지정
 *  	 HTML / XML / JSON
 *       response.setContentType("text/html")    
 *       response.setContentType("text/xml")    
 *       response.setContentType("text/plain")    
 *     2) 클라이언트 브라우저에서 읽어 갈 수 있게 메모리에 저장
 *       PrintWriter out=response.getWriter()
 *                       ====================== 사용자 브라우저
 *       out.write("<html>")
 *     3) 데이터 베이스 연결
 *     
 *   
 */
@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String msg;
	
	public void init(ServletConfig config) throws ServletException {
				msg="Hello Servlet!!";
//		web.xml을 통해서 필요한 데이터 전송
//		web.xml을 읽어오는 라이브러리
	}
	public void destroy() {
		System.out.println("destroy() : 서블릿 메모리 해제");
/*
 *		브라우저 : localhost 요청
 *      DNS : localhost => 127.0.0.1 (IP로 변환)
 *      변환된 IP를 이용해서 서버에 접속 => new Socket (ip.80)
 *     	파일을 찾아서 실행된 결과를 메모리에 저장
 *     				out.white("<html>") 
 *     		
 */
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		디폴트 => 화면출력
//		1. 전송 방식
		response.setContentType("text/html;charset=UTF-8");
//		2. html을 요청한 브라우저로 전송
		PrintWriter out = response.getWriter(); // 브라우저 확인 (response안에 사용자의 IP 를 가지고 있다)
//		out 영역에 html을 작성하면 브라우저에서 읽어 간다 => 화면에 출력이 된다
		out.write("<html>");
		out.write("<body>");
		out.write("<center>");
		out.write("<h3>IP:"+request.getRemoteAddr()+"</h3>");
		out.write("<h3>요청내용:"+request.getRequestURL()+"</h3>");
		out.write("<h3>실제 요청내용:"+request.getRequestURI()+"</h3>");
		out.write("</center>");
		out.write("</body>");
		out.write("</html>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}






