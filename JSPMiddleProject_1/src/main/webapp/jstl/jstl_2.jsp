<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	width : 800px;
}
h3{
	text-align:center; 
	
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<h3> 자바 => 구구단</h3>
			<table class="table">
				<tr class="success">
				<%
					for(int i=2; i<=9; i++){
				%>
					<th class="text-center"><%=i %> 단</th>
				<%
					}
				%>
				</tr>
				<%
					for(int i=1; i<=9; i++){
				%>
						<tr>
				<%				
						for(int j=2; j<=9; j++){
				%>
						<td class="text-center"><%=j+"*"+i+"="+j*i %></td>		
				<%
						}				
				%>
						</tr>
				<%
					}
				%>
			</table>
		</div>
		<div class="row">
			<h3>JSTL => 99단</h3>
			<table class="table">
				<tr class="danger">
					<c:forEach var="i" begin="2" end="9">
						<th class="text-center">${i+="단" }</th>
					</c:forEach>
				</tr>
					<c:forEach var="i" begin="1" end="9">
					<tr>
						<c:forEach var="j" begin="2" end="9">
							<td class="text-center">${j }*${i }=${j*i }</td>
						</c:forEach>
					</c:forEach>
			</table>
		</div>
	</div>
	
	
</body>
</html>







