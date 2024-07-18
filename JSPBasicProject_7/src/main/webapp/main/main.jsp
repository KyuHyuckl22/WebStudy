<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.change.*"%>
<jsp:useBean id="change" class="com.sist.change.JspChange"></jsp:useBean>
<%--
	JSPChange change=new JspChange() 
 --%>
 <%
 	String mode=request.getParameter("mode"); // 화면 변경
 	if(mode==null){ //첫번째 화면
 		mode="0";
 	}
 	int index=Integer.parseInt(mode);
 	String jsp=change.change(index);
	
 	switch (index) {
 	case 0:
 		jsp = "../food/home.jsp";
 		break;
 	case 1:
 		jsp = "../food/detail.jsp";
 		break;
 	case 2:
 		jsp = "../main/header.jsp";
 		break;
 	case 3:
 		jsp = "../store/store.jsp";
 		break;
 	}
 	
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
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
		<jsp:include page="<%=jsp %>"></jsp:include>
	</div>
</body>
</html>










