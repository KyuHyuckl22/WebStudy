<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%--
	prefix="c"  < c:   으로 시작한다
	prefix="core" < core:  으로 시작해야 한다
 --%>
<%--
	J	JSP
	S	Standard
	T	Tag
	L   Library
	
		=> 태그로 제어문, String, 날짜, 숫자 ... 화면 이동 => jstl-1.2jar
		=> 자바 문법을 태그로 제작 (사용자 정의 => x)
		=> EL / JSTL => JSP 화면 출력
		=> 1.core	:제어문, 변수 선언, 화면 이동
			제어문
				반복문
				<c:forEach>
				=> 속성 : begin, end, step
						시작     끝    증가 (감소는 없다)
				for(int i=1; i<=10; i++)
			=>  <c:forEach var="i" begin="1" end="10" step="1">
											 10을 포함   ======= 
											 		   생략 가능
				for(FoodVO vo:list)
			=>	<c:forEach var="vo" items="list">
			
			=> 	StringTokenizer st=new StringTokenizer()
				=> <c:forTokens var="s" value="red,blue,blak" delimt=",">
															  ====== 구분자
				조건문
				<c:if>
				선택문 
				<c:choose>
				<c:when></c:when>
				<c:when></c:when>
				<c:otherwise></c:otherwise> => default
				</c:choose>
				
		   2.fmt  	:날짜 변환, 숫자 변환
		   3.fn		:String 메소드를 처리
		   =========
		   4.xml
		   5.sql
		   ========= 노출 => 순수 자바(DAO)
 --%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>일반 자바 for문</h3>
	<%
		for(int i=1; i<=10; i++){
	%>
		<%=i %>&nbsp;
	<%	
		}
	%>
	<h3>JSTL forEach</h3>
	<c:forEach var="i" begin="1" end="10" step="1">
		${i }&nbsp;
	</c:forEach>
</body>
</html>















