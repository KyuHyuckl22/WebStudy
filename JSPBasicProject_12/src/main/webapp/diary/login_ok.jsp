<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.dao.*"%>
<%
	//사용자가 보내준 값을 받는다
	String id=request.getParameter("id");
	String pwd=request.getParameter("pwd");
	//오라클로부터 결과값을 받는다
	DiaryService dao=DiaryService.newInstance();
	MemberVO vo=dao.isLogin(id, pwd);
	
	if(vo.getMsg().equals("NOID")){
	%>
		<script type="text/javascript">
			alert("아이디를 확인해주세요")
			history.back();
		</script>
	<%
	}else if (vo.getMsg().equals("NOPWD")){
	%>	
	<script type="text/javascript">
			alert("비밀번호를 확인해주세요")
			history.back();
		</script>
	<%
	}else {

		//데이터를 저장 => 지속적으로 관리 => 30분
		// 세션에 저장
		session.setAttribute("id", vo.getId());
		session.setAttribute("name",vo.getName());
		session.setAttribute("sex", vo.getSex());
		
		response.sendRedirect("middle.jsp");
	}
	%>
	
	
			
   
