package com.sist.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DataoutputServelt")
public class DataoutputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public void init(ServletConfig config) throws ServletException {
		System.out.println("DataOutputServlet:init() call");
	}


	public void destroy() {
		System.out.println("DataOutputServlet:destroy");
/*
 * <% 
 * 
 * %>		
 * <html> (html은 화면출력하는것)
 *   	 	화면을 출력하기 위해서는
 *   		Java 에서 데이터를 가져와야 화면출력이 가능
 *   		그래서 항상 순서는 java가 먼저임.
 */
	}

/*
 *      매개변수는 호출시마다 변경=> request가 계속변경이 된다
 *      
 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	  	1. 브라우저 전송 : HTML
		response.setContentType("text/html;charset=UTF-8");
//		2. 사용자 보내준 값을 받는다
/*
 * 		사용자 전송 ====> 모든 전송된 데이터는 request 안에 있다 => 구분자 : name (text 구분자)
 *      request => HttpServletRequest
 *                 ==================
 *                 javax.servlet.http.HttpServletRequest
 *                 => tomcat 9   ( 9버전을 사용하는 이유 java 와 연동을 해야하기 때문)
 *                 jakarata.servlet.http.HttpServleRequest
 *                 => tomcat10
 *      1) 서버정보
 *        http://localhost:80
 *        =================== 서버 IP / 서버 PORT
 *              => getSercerInfo() / getPort()
 *      2) 사용자 전송 정보
 *        => setCharacterEncodint() : 디코딩 (1byte => 2byte)
 *        => getParameter() => 단일값
 *        => getParameterValues
 *      3) 추가정보
 *        => setAttibute()
 *        get
 *      
 */
//		3. 데이터베이스 연결
//		4. HTML을 메모리에 저장
		request.setCharacterEncoding("UTF-8"); //한글깨짐 방지
		
		String name=request.getParameter("name");
		String sex=request.getParameter("sex");
		String tel1=request.getParameter("tel1");
		String tel2=request.getParameter("tel2");
		String content=request.getParameter("content");
		String[] hobby=request.getParameterValues("hobby");
		
		PrintWriter out=response.getWriter();
		out.write("<html>");
		out.write("<body>");
		out.write("<center>");
		out.write("<h3>클라이언트가 보내준 값</h3>");
		out.write("이름:"+name+"<br>");
		out.write("성별:"+sex+"<br>");
		out.write("전화:"+tel1+")"+tel2+"<br>");
		out.write("취미:<br>");
		out.write("<ul>");

		try {
			for(String s:hobby) {
				out.write("<li>"+s+"</li>");
			}
		}catch(Exception ex) {
			out.write("<font color=red>취미가 없습니다</font>");
			
		}
		out.write("</ul>");
		out.write("<a href=\"DataInputServlet\":>입력</a>");
		out.write("<hr>");
		out.write("<h3>request의 기본 기능</h3>");
		out.write("서버명:" + request.getServerName()+"<br>");
		out.write("서버정보:" + request.getServerPort()+"<br>");
		out.write("클라이언트IP:" + request.getRemoteAddr()+"<br>");
		out.write("URL:"+request.getRequestURL()+"<br>");
		out.write("URI:"+request.getRequestURI()+"<br>");
		out.write("");
		out.write("</body>");
		out.write("</html>");
				
				
				
		
	}

}





