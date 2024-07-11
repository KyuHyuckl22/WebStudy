<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	request / response / session 
	application / out /pageContext
	page / config / exception
	==============================
	Cookie : 최신 방문 => 보안 노출
	=> session
	=> 빈즈 => VO, DAO
	=> DAO= DBCP 전한
	=>:MVC => MV / MVC
	
	 --%>
<%
	String mode=request.getParameter("mode");
	if(mode==null)
		mode="1";
	int index = Integer.parseInt(mode);
	String jsp="";

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
.row{
	margin : 0px auto;
	width : 960px;
}
.a{
	white-space: nowrap;
	overflow: hidden;
	text-overflow:ellipsis;
}
</style>
</head>
<body>
	
</body>
</html>