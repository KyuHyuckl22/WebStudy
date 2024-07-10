<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	while : 반복문 =>웹 에서는 출력 횟수 지정 : for
	이미지 슬라이드 => 자바 스크립트
 --%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		int i=5;
		String s="";
		while(true){
			if(i>5)
			{
				break;
			}
			s+='★';
			i++;
		}
	%>
	<font color=red>,<%=s %> %></font>
</body>
</html>