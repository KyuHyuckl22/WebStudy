<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	<% %>
	<%!%> 
 --%>
 <%!
 	// 선언문
 	public int add(int a , int b)
 	{
	 return a+b;
			 
 	}
 %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		int res=add(10,20);
	    out.print(res); //servlet cord
	    
	%>
	<%=res %>
<%--
	<% %> 안에 <%%> 가 들어갈 수 없다
	ex) <%
		if()
		{
		%>
		<%
		}
		%>
		<%
		else if()
		{
		%>
		<%
		}
		%>
		<%
		else if()
		{
		%>
		<%
		}
		%>
		<%
		else
		{
		%>
		<%
		}
		%>
		
 --%>
</body>
</html>