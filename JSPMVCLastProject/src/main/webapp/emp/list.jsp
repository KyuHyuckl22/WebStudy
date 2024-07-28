<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,service.*"%>
<%
	EmpDAO dao=EmpDAO.newInstance();
	List<EmpVO> list=dao.empListData();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		for(EmpVO vo:list)
		{
	%>
		<li><%=vo.getEmpno() %>-<%=vo.getEname() %></li>
	<%
		}
	%>
</body>
</html>