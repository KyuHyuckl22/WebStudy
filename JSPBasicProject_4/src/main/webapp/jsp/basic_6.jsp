<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//선언되는 변수 = 지역변수 => 초기화를 해서 사용해야 한다
	int a=10;
	int b=20;
	java.util.Date date= new java.util.Date();
	java.text.SimpleDateFormat  sdf=new java.text.SimpleDateFormat("yyyy--MM--dd");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		out.print(a+b);
	%>
	<br>
	<%=a %>&nbsp;<%=a*b %>
	<br>
	<%="Hello JSP"/**/%>
</body>
</html>