<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"import="com.sist.model.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	// 배열
	String[] colors={"green","blue","yellow","pink","orange"};
	request.setAttribute("colors",colors); // ${request.getAttribute()}
	// $ 는 request 나 session 이 있어야 값을 가지고 올 수 있다
	//
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3> Java => 향상된 for문(for-each)</h3>
	<ul>
	<%
		int i=1;
		for(String color:colors){
	%>
		<li><%=i%>.<%=color %></li>
	<%
		i++;
		}
	%>
	</ul>
	<h3> JSTL => for-Each</h3>
	<ul>
	<%--
		varStatus = "s" : 배열 / 컬렉션의 인덱스 번호 => 0
	 --%>
		<c:forEach var="color" items="${colors }" varStatus="s">
			<li>${s.index+1 }.${color }</li>
		</c:forEach>
	</ul>
</body>
</html>
















