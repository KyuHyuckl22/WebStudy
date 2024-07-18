<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	pageContext.forward("output.jsp"); //request를 전송
	/*
		forword는 파일 전송시 request를 유지하고 싶을때 사용 =>URL이 동일
		sendRedirect 는 파일 전송시 request를 초기화 후 파일 이동 =>URL변경
	*/
%>