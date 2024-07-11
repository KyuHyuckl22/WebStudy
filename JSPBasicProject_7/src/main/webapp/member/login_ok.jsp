<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.dao.*"%>
<jsp:useBean id="dao" class="com.sist.dao.MemberDAO"></jsp:useBean>
<%-- MemberDAO dao = new MemberDAO() 와 같은 내용 --%>
<%
	request.setCharacterEncoding("UTF-8");
	// 사용자가 보내준 ID, PWD를 받는다
	String id=request.getParameter("id");
	String pwd=request.getParameter("pwd");
	
	// db 연동 오라클에 있는가? 
	MemberVO vo = dao.isLogin(id, pwd);
	
	if(vo.getMsg().equals("NOID")){
		// 이동
%>
	<script>
		alert("아이디를 확인해주세요")
		history.back();
	</script>
<% 
	}else if (vo.getMsg().equals("NOPWD")){
%>
	<script>
		alert("비밀번호를 확인해주세요")
		history.back();
	</script>
<% 		
		// 이동
		
	}else{
		// 세션에 저장
		session.setAttribute("id",id);
		session.setAttribute("name",vo.getName());
		// 이동
		response.sendRedirect("../main/main.jsp");
	}
	
%>
