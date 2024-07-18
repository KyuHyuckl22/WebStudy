<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	RequestDispatcher rd = request.getRequestDispatcher("output.jsp");
	rd.forward(request,response);
	/*
		HTML 화면 이동 : <a>, <form> => 데이터 전송, 화면 변경
		Java 화면 이동 : 서버에서 변경 ->(사용자는 login 을 요청했는데)
								 (main 화면을 보여줄 수도 있음)
			pageContext.forward()
			RequestDispatcher.forward()
		  ============================== ↑ request 유지
		  ============================== ↓ request 초기화
			response.sendRedirect()
			
		JavaScript 화면 이동
			location.href="파일명"
		  ===============================
	*/
%>