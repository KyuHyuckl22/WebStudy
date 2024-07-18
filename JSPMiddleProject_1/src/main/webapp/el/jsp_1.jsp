<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%
	List<String> list=new ArrayList<String>();
	list.add("고길동");
	list.add("둘리");
	list.add("또치");
	list.add("도우너");
	list.add("박희동");
	
	request.setAttribute("list", list);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>이름 출력</h1>
	<ul>
	<%
		for(String name:list){
	
	%>
		<li><%=name %></li>	
	<%
		}
	%>
	</ul>
	<h1>이름 출력2</h1>
	<ul>
		<c:forEach var="name" items="${list }">
			<li>${name }</li>
		</c:forEach>
	</ul>
</body>
</html>