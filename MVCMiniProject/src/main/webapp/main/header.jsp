<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
	MVC 
	=> HTML / Java 를 분리해서 사용하기위함
	=> 소스가 적어진다 / 파일 수가 적어진다 (x)
		HTML = JSP
		Java => java   파일이 2배로 늘어난다..
	==================================== 하지만 여러명의 개발자가 동시에 개발 가능! (분업)
	=> JSP 
		= 보안이 취약 (자바 => .class (가 되면 파일을 볼 수 없다) => JSP는 소스를 통으로 넘겨준다)
 	    = 재사용이 어렵다
 	=> HTML / Java => 연결하는 파일
 	  (View) (Model)  (Controller)
  	=> MVC구조의 동작
  		사용자 요청 (<form>,<a>,JavaScript)
  		      |
  		Controller
  		=> Servlet / JSP => URL 주소를 이용해서 데이터를 전송
  							=======================
  							일반 자바는 request가 없기 때문에 받을 수 없음
  							서블릿 / JSP 연결 
  		역할) 1) 사용자 요청 받기
  			2) Model을 찾는다
  			   ===== 자바 (클래스) => 연관된 기능만 가지고 있다
  			3) 요청 결과값 가지고 온다 (request/session)
  				request : 한개의 JSP 에서만 사용시에
  				session : 모든 JSP 에 데이터를 공유
  			4) 요청한 JSP 로 request 를 전송한다
  			  ============================ forward
  	
  		   
	
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="wrapper row1">
		<header id="header" class="clear">
			<%--
  	EL
  			   request.setAttribute("키",값)
  		${값} => request.getAttribute("키");
  		${requestScope.값}
   --%>
			<!--############################################################################### -->
			<div id="logo" class="fl_left">
				<h1>
					<a href="index.html">맛집 And 서울여행</a>
				</h1>
			</div>
			<div class="fl_right">
				<c:if test="${sessionScope.id==null }">
					<ul class="inline">
						<li><i class="fa fa-phone"></i><input type="text"
							class="input-sm" placeholder="아이디"></li>
						<li><i class="fa fa-envelope-o"></i><input type="password"
							class="input-sm" placeholder="비밀번호"></li>
						<li><input type=image src="../main/login.png"
							style="width: 100px; height: 25px">
					</ul>
				</c:if>
				<c:if test="${sessionScope.id!=null }">
					<ul class="inline">
						<li>${sessionScope.name }님로그인되었습니다.</li>
						<li><input type=image src="../main/logout.png"
							style="width: 100px; height: 25px">
					</ul>
				</c:if>
			</div>
		</header>
	</div>

	<div class="wrapper row2">
		<nav id="mainav" class="clear">
			<ul class="clear">
				<li class="active"><a href="../main/main.do">홈</a></li>
				<li><a class="drop" href="#">회원</a>
					<ul>
						<li><a href="pages/gallery.html">회원가입</a></li>
						<li><a href="pages/full-width.html">아이디 찾기</a></li>
						<li><a href="pages/sidebar-left.html">비밀번호 찾기</a></li>
					</ul></li>
				<li><a class="drop" href="#">맛집</a>
					<ul>
						<li><a href="../food/list.do">맛집 목록</a></li>
						<%-- Controller 를 찾을때 URL 패턴=> .do --%>
						<c:if test="${sessionScope.id!=null }">
							<li><a href="pages/full-width.html">맛집 예약</a></li>
						</c:if>
						<li><a href="../food/find.do">지역별 맛집 찾기</a></li>
						<li><a href="pages/sidebar-left.html">맛집 관광</a></li>
					</ul></li>
				<li><a class="drop" href="#">서울 여행</a>
					<ul>
						<li><a href="../seoul/list.do">명소</a></li>
						<li><a href="pages/full-width.html">자연 & 관광</a></li>
						<li><a href="pages/sidebar-left.html">쇼핑</a></li>
						<li><a href="pages/sidebar-left.html">호텔</a></li>
						<li><a href="pages/sidebar-left.html">서울 날씨</a></li>
					</ul></li>
				<li><a class="drop" href="#">커뮤니티</a>
					<ul>
						<li><a href="../board/list.do">자유게시판</a></li>
						<li><a href="pages/full-width.html">공지사항</a></li>
						<c:if test="${sessionScope.id!=null }">
							<li><a href="pages/sidebar-left.html">묻고 답하기</a></li>
							<li><a href="pages/sidebar-left.html">실시간 채팅</a></li>
						</c:if>
					</ul></li>
				<li><a class="drop" href="#">스토어</a> <c:if
						test="${sessionScope.id!=null }">
						<c:if test="">
							<li><a href="#">마이페이지</a></li>
						</c:if>
						<c:if test="${sessionScope.id!=null }">
							<li><a href="#">관리자페이지</a></li>
						</c:if>
						</c:if>
			</ul>
		</nav>
	</div>
</body>
</html>