<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	pageContext => 파일 연결 => 흐름을 제어
	=> 클래스명 : PageContext
	1) 내장 객체 얻기
		getRequest() : request 객체를 얻어오는 경우
		getResponse() , getOut() , getSession()
		
		request.getParameter()
		pageContext.getRequest().getParameter()
	2) 흐름 제어 (*******)
		=> include() => <jsp:include> => pageContext.include("파일명")
		=> forward() => <jsp:forward>
	  ================ request를 공유할 수 있다
	  
	  		?  ===== request 로 값 가져오기 => 웹서버
	  => a._jspService(HttpServletRequest request)
	  	=> b._jspService(){
	  	}
	  	forward 기법
	  
	  	main._jspService(request) {
	  		a._jspService(request)
	  		b._jspService(request)
	  		c._jspService(request)
	  	}
	  	이렇게 request 를 공유할 수 있게 만들어주는게
	  	include 파일이다
	  	
	  	
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