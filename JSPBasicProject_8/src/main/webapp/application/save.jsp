<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%
//	String path = "C:\\Users\\user\\git\\web-stuy\\JSPBasicProject_8\\src\\main\\webapp\\application";
	String path = application.getRealPath("/application");
	String euctype = "UTF-8";
	int max = 1024*1024*100; //100MB 가 max
	// cos.jar => 파일 업로드 라이브러리  com.oreilly.servlet == cos 
	MultipartRequest mr = 
		new MultipartRequest(request, path, max, euctype,
				new DefaultFileRenamePolicy());
	//             ======================== 파일명이 같은 경우는 1씩 증가 시키기
	//		    ex)file 이 있는데 또 생성하면 file(1) 이라고 나오는거
	String fn = mr.getOriginalFileName("upload");
	response.sendRedirect("output.jsp?fn="+fn);

%>    
    
    
