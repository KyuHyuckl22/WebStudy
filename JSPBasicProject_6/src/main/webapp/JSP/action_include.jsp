<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--
	151p
		액션 태그
		동작 / 액션이 일어나는 시점에 페이지와 페이지 사이에 제어
		<jsp:include> : JSP안에 다른 JSP를 포함하는 경우 => 화면 분할 (조립식)
			=> 속성 : page="" => 포함하는 파일 지정
			=> xml 형식으로 만들어져 있다
			  ==== 문법이 복잡하다
			  1) 속성이나 태그명은 대소문자를 구분한다
			  2) 속성에 값을 첨부할때는 반드시 ""
			  3) 반드시 여는 태그와 닫는 태그가 동일, 독립태그 사용
			  4) 동적으로 변경 (파일마다 따로 컴파일 후에 HTML 만 첨부)
			<jsp:useBean> : 객체 메모리 할당 
			  => id=""		: 객체명
			  => class=""	: 클래스명
			  => scope=""	: 언제 메모리 할당해서 사용하는 범위
			  	========
			  	page / session / application / request
			  		   | 		 |              └ 사용자의 요청값이 있는 경우
			  		   |         └ 객체를 모든 JSP 에서 사용하고 싶은 경우
			  		   └브라우저에 유지하고 있는 동안
			  	===== default
			  	=> JSP안에서 사용
		MemberVO vo=new MemberVO();
		<jsp:useBean id="vo" class="com.sist.bean.MemberVO"> 항상 패키지명부터 붙여서 처리
					 ======= 객체명  ======================== 클래스 선언	
		<jsp:setProperty> => setter 에 값을 설정할때 
			=> name : 객체명 => useBean 에서 설정된 id명 과 일치
			=> property : 변수명
			   property = "name" 을 주게되면 => setName()
			   property = "sex" 가 들어가면  => setSex()
			   property = "*"  이 들어가면 => 모든 setter 에 값을 채워라
			   
		<jsp:forward page="파일명"> 
			서버에서 화면을 이동할 경우에 사용
			= sendRedirect() : URL을 변경 => request가 초기화
			= forward() : URL 변경이 없다 => request를 가지고 있다 => MVC 기법
			
 --%>	
	
<%
request.setCharacterEncoding("UTF-8");
String mode = request.getParameter("mode");
String jsp = "";
if (mode == null)
	mode = "0";
int index = Integer.parseInt(mode);

switch (index) {
case 0:
	jsp = "home.jsp";
	break;
case 1:
	jsp = "join.jsp";
	break;
case 2:
	jsp = "idfind.jsp";
	break;
case 3:
	jsp = "pwdfind.jsp";
	break;
case 4:
	jsp = "send.jsp";
	break;
case 5:
	jsp = "mypage.jsp";
	break;
case 6:
	jsp = "recv.jsp";
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
.row {
	margin: 0px auto;
	width: 960px;
}
</style>
</head>
<body>
	<jsp:include page="nav.jsp"></jsp:include>
	<div class="container">
		<jsp:include page="<%=jsp%>"></jsp:include>

	</div>
</body>
</html>