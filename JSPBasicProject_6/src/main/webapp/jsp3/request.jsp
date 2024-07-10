<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	JSP 파일 => 메소드를 구현
	=======   _jspService()
			{
				소스코딩
			}

	내부객체 (내장객체, 기본객체)    ==> 165p
	====================   
	선언이 되어있는 객체
	★★HttpServletRequest request						    파일명
		1. 서버정보 / 브라우저 정보							   ================
		  http://localhost:8080     /JSPBasicProject_6/jsp3/request.jsp  => URL
		  =====================     =================================== URI (사용자가 요청한 값)
	   서버 IP / Port (80은 생략이 가능)   ================= ContextPath
											  			└ 구분자가 없다 : 파일명 자체가 구분자다	   
	   		=> getServerName() => localhost
	   		   AWS : 각자마다 고정 IP를 부여
	   		=> getProtocol() => 약속이라는 뜻 => http
	   		=> getPort() : 80
	   				=			=> getRequestURL()
	   							=> getRequestURI()
	   							=> getContextPath()
	   							=> 클라이언트의 IP : getRemoteAddress()
		2. 사용자 요청 정보
			=> 사용자가 보내준 데이터를 받는 메소드
				String getParameter() : 단일값을 받을 때 사용
				String[] getParameterValues() : chechbox, select => multiple
				setCharacterEncoding() => 디코딩
		3. 데이터 추가 정보
				setAttribute() : 추가
				getAttribute() : 추가된 데이터 읽기
				removeAttribute() : 삭제
	★★HttpServletResponse response
  	★★PageContext pageContext;
  				<jsp:include> , <japforward>
  	★★HttpSession session = null;
  	★★ServletContext application;
  	ServletConfig config;
  	★JspWriter out = null;
  	Object page = this;
	
 --%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootsatrap/3.4.1/css">
<style type="text/css">
.container {
	margin-top 50px;
}
.row {
	margin : 0px auto;
	width : 600px
}
</style>
</head>
<body>
	<div class="container">
		<h3 class="text-center" >전송</h3>
		<div class="row">
			<table class="table">
				<tr>
					<th width=20%></th>
					<td width=80%>
					<input type=text size=20 class="input-sm" name=name>
					</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>