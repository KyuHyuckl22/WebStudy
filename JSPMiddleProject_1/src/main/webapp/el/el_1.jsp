<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	EL : 표현식 => 데이터를 화면에 출력
		<%= %> => 대체
		${값}
		=> 연산자
		=> 내장 객체
 --%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String name="홍길동";
	//	EL 사용시
		request.setAttribute("name", "고길동"); 
		session.setAttribute("sex", "남자");
	//  EL:${키}
	%>
	<h1>EL:${name }</h1>
	<h1>EL:${sex }</h1>
	<h1><%=name %></h1>
</body>
</html>