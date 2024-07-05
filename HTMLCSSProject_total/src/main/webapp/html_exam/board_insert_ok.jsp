<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.dao.*"%>
<%
	// 사용자가 보내준 값을 받는다
	// 한글이 들어왔을때 반드시 한글 처리를 해야 한다 = decoding
	request.setCharacterEncoding("UTF-8");
	String name=request.getParameter("name"); // name에서 값이 name 인 값을 가져와라
	String subject=request.getParameter("subject"); //name 에서 값이 subject 인 값을 가져와라
	String content=request.getParameter("content"); //name 에서 값이 content 인 값을 가져와라
	String pwd=request.getParameter("pwd"); // name 에서 값이 pwd 인 값을 가져와라
	
	BoardVO vo = new BoardVO();
	vo.setName(name);
	vo.setSubject(subject);
	vo.setContent(content);
	vo.setPwd(pwd);
	// dao 를 통해서 오라클 전송.
	BoardDAO dao=BoardDAO.newInstance();
	dao.boardInsert(vo);
	// 화면이동 => board_list.jsp로 이동
	response.sendRedirect("board_list.jsp");
	
%>



