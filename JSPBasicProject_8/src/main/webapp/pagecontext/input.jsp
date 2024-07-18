<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	사용자가 데이터를 전송했을 때 데이터를 전송하는 방법 : ?변수=값 => get 
		 								<form> => submit => POST
		 								================ request에 값을 모아서 전송
		 								
 --%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="save.jsp"><%-- form 에서 일어나는 일을 save.jsp로 보내겠다 --%>
		ID:<input type=text name=id size=15><br>		
		pw:<input type=password name=pwd size=15><br>		
		<input type=submit value="전송">
	</form>
</body>
</html>




