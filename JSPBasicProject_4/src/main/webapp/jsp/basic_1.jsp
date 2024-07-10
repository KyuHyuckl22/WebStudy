<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	JSP 동작 구조
	1. jsp 파일 요청 => URL
	   http://localhost/JSPBasicProject_4/jsp/basic_1.jsp
	2. 웹 서버가 요청을 받는다
	   httpd
	   => .html, .xml => 만 처리가 가능하다
	   => .jsp, servlet => 처리를 못한다
	3. WAS (Tomcat)로 전송 (WAS가 처리해줌) 
	4. jsp파일을 자바 파일로 변경
		ex) a.jsp  ====>   a_jsp.java
			=====
			 └ 여기에 코딩한 내용을 => public void _jspService() 에 첨부
	5. 서블릿을 컴파일 => a_jsp.class 
	6. 실행 (인터프리터)
	   out.write() 에 있는 내용만 메모리에 저장
    7. 저장된 메모리에서 브라우저를 읽어서 출력
    	
		
		
		
 --%>		
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body> 
	<!-- 화면에 출력하는 태그 -->
	<%-- 화면에 출력하는 태그 --%>
	
</body>
</html>





