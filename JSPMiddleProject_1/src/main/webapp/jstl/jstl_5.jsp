<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>자바: StringTokenizer</h1>
	<ul>
	<%
		String color="red,blue,yellow,black,green,pink,magenta";
		StringTokenizer st=new StringTokenizer(color,",");
		while(st.hasMoreTokens()){
	%>
		<li><%=st.nextToken() %></li>
	<%		
		}
	%>
	</ul>
	<h1>JSTL : &lt;c:forTokens&gt;</h1>
	<ul>
		<c:forTokens var="color" items="red,blue,yellow,black,green,pink,magenta" delims=","></c:forTokens>
		<li></li>
	</ul>
</body>
</html>