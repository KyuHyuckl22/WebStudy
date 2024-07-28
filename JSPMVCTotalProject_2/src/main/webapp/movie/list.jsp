<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	JSP / Servlet
	JSP
		1. 지시자 
			= page 지시자 : contentType="" => 브라우저에 알려주는 방식
							메모리에 저장된 데이터가 어떤 형식인지 알려준다 => response
									   ===========
									   1) HTML   2) XML   3) JSON
									 text/html   text/xml	text/plain     데이터를 보낼때 형식
			= taglib 지시자 : 태그형으로 자바의 제어문을 지원
							prefix="개인따라 지정:c/ fmt /sql / xml / fn" uri="
							
							<c:
							==
				-제어문 / 화면 이동
				<c:if test="조건문:>
				<c:forEach var="받는 변수" items="배열/컬렉션" varStatus="인덱스 변호">
				<c:forEach var="변수명" begin="" end="">
				<c:choose>
				    <c:when test=""></c:when>
				    <c:when test=""></c:when>
					<c:otherwise></c:otherwise>
				<c:choose>
				
				<c:set var="" value="">  -> request.setAttribute(var값, value값)
				<c:redirect url="이동 주소:>
				
				-EL : 데이터 출력
				${requestScope.키} => request.setAttribute()
				${sessionScope.키} => session.setAttribute()

			 => 문자열 결합 ${+=}
			 
			 Servlet: 자바로만 소스코딩 => JSP 
			 =======
			 실행 순서
			 1) init()
			 2) service(): GET/POST
			 		= doGet()  
			 		= doPost() 
			 3) destory() : 메모리 해제 => 화면이동, 새로고침 (자동으로 메모리 헤제)
			 
		MVC
		===
			HTML / Java 분리
			
			MVC의 장점 : 분업화가 좋다 (여러명의 개발자가 동시 개발이 가능)
						Front/ Back
						=> 개발속도 빠르다 (재사용,확장성)
			= Controller : JSP / Servlet
								 =========== 보안 유지(.class) : 스프링, 스트럿츠 => 제공
								 
			= Model : 요청처리
						오라클에서  데이터 읽기 / 쓰기 / 수정 /  삭제
						=> DAO,VO,Magegwr
						사이트에서 데이터를 읽기 => 웹 크롤링
						OPEN API => api 키를 이용해서 처리(증권)
						** 데이터 관리 (입출력)
			=View : 브라우저 출력용
					
			= 클래스 단위
			  메소드 단위 (*********) => 어노테이션 (찾기기능)
			  
			= 내장 객체
				=> request / response / session
				=> cookie
				=> 외부 라이브러리 
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









