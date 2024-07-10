<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	자바 문법 사용
	제어문
	if / if else / if~else if~else 
	=>관리자 일반 사용자 구분
	while / for / break
	        └목록		└페이지
	
 --%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//1~100 까지 : 짝수합 / 홀수합 / 전체합
		int sum=0, even=0, odd=0;
	for(int i=1;i<=100;i++)
	{
		sum+=i;
		if(i%2==0)
			even+=i;
		else
			odd+=i;
	}
	%>
	<%= %>
	<%= %>
	<%= %>
</body>
</html>