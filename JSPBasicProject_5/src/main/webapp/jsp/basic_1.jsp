<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
		JSP (Java Server Page)
	1)HTML / Java => 구분 <%%> <%=%> <%! %>
	2) 지시자 : 139p
		page		JSP의 기본 정보를 저장하고 있다.
					지시자 : <%@ 지시자명 속성="값" 속성="값" ...%>
							page contentType = "text/html"
						   <%@ include file = "파일명">
						    ========================= JSP 는 조립식 프로그램
						   <% taglib prefix="core" ...%>
						       <c:forEach> => <core:forEach>
		속 성 
			**info 		:작성자 , 작성일 , 무슨 프로그램인지
			language	:java => default
			**contentType : respon.setContentType()
			=> 브라우저에 어떤 형식인지 알려준다
				=> text / html; charset = ISO-8859-1 => def
			extends
			**import
			session
			**buffer
			autoFlush
			isThreadsafe
			trmDirdctive
			WhitSpace
			errorPage
			**isErrorPage
			**pageEncodin
		taglib
		include
	3)내장 객체
		request
		response
		session
		out
		application
		config
	4)cookie
	5)JSP 액션 태그 <jsp:include><jsp:useBean><jsp:forward>
	=================== Basic
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>