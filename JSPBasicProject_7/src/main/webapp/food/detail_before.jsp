<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String fno=request.getParameter("fno");
	Cookie cookie = new Cookie("food_"+fno,fno);
	
 	cookie.setPath("/");
 	cookie.setMaxAge(60*60*24);
 	
 	response.addCookie(cookie);
 	
 	response.sendRedirect("../main/main.jsp?mode=1&fno="+fno);
%>