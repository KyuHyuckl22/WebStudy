<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.dao.*"%>
<jsp:useBean id="dao" class="com.sist.dao.ReplyDAO"></jsp:useBean>
<%
	request.setCharacterEncoding("UTF-8");
	String fno=request.getParameter("fno");
	String msg=request.getParameter("msg");
	
	//세션 생성
	String id=(String) session.getAttribute("id");
	String name=(String) session.getAttribute("name"); //형 변환 시켜서 가져오기
	
	
	/*
		Session 은 데이터 저장 => object => List, vo...
		Cookie 는 데이터 저장 => 문장열만 저장이 가능
	*/
	
	ReplyVO vo = new ReplyVO();
	vo.setFno(Integer.parseInt(fno));
	vo.setMsg(msg);
	vo.setId(id);
	vo.setName(name);
	vo.setType(1);
	
	dao.replyInsert(vo);
	
	//이동
	response.sendRedirect("../main/main.jsp?mode=1&fno="+fno);
	
%>
