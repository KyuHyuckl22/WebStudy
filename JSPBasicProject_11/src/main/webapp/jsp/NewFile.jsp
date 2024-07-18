<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	1. HTML / 자바 분리 => MVC, Spring 에서는 나오지 않는다
		<% %> ,  <%= %>
	2. 지시자
	  	page
	  		import, contentype 
	3. 내장 객체 : MVC / Spring
	 	request
	 	= getParameter()
	 	= getParameterValues()
	 	= setCharcterEnCoding()
	 	= get Session() /geetcookie()
	 	= 
	 	response
	 	= setHeader()
	 	= sendRedirect()
	 	= addCookie()
	 	session
	 	= setAttribute()
	 	= getAttribute()
	 	= invalidate()
	 	= removeAttribthi
	 	application
	 	= getRealPath()
	 	= cookie (내장 객체가 아니다) => 문자열만 저장 가능
	 	= setPath()
	 	= setMaxAge() => 저장기간 => 0이면 삭제
	 데이터 베이스 : DBCP , JDBC => 자바와 오라클 연결
	 MVC를 위한 준비 : EL / JSTL/ MVC롤 제작
	 라이브러리 => cos.jar , commons-dbcp.jar, commons-pool.jar|
	              |    ====================================tomcat
	              
	 Cookie : 브라우저에 저장
	 		=> 보안이 취약
	 		=> 아마존에서 주로 사용(로그인)
	 		=> 최근 방문 / 자동 로그인 
	 	=> 저장 : 생성자 이용 vcoo
	 		cookie cookie = new cookie (String key,String value)
	 	=> 저장 기간 설정 : setMaxAge(1800) => 초단위
	 			60*60*24
	 	=> 저장 위치 설정 : setPath("\")
	 	=> 브라우저로 전송
	 	=> 키 얻기 : getName()
	 	=> 값 얻기 : getvlue()
	 	=> 쿠키 전체 읽기 : request.getcooki
	 	================================================================
	 	sesstion : 서버에 저장 (사용자의 일부 정보 저장)
	 					=> 상품 정보 (장바구니)
	 	=> 저장 : setAttribute()
	 	=> 저장 값 일기 : getAttribute()
	 	=> 저장된 데이터를 1 개씩 : rwmoveAttribute()
	 	=> 저장된 데이터를 전체 삭제 : invalidate()
	 	=> 저장 기간을 설정  : 디폴트 30분			
	 		setMaxInactivc	
	 	
	                     

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