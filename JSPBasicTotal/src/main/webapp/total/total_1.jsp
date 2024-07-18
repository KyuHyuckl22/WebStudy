<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	1. JSP의 실행 과정
				실행요청을 하면 톰캣이 실행해줌     자바로 변경
		a.jsp =======================> a_jsp.java
						
				jsp파일 요청 => URL=> request
		브라우저 ===================> 톰캣
			  <==================
			  요청 처리 후에 응답 HTML => request
			  =========
		JSP사용
			지시자 : page => JSP 에 대한 정보를 저장
					1) 변환 => 브라우저에 알림
						contentType="text/html, text/xml, text/plain"
									==========			 ============
									vo=>{}   ,lList => [{},{} ...]
					2) 외부 라이브러리 => import
					  =========== java.lang, javax.http, servltdhl ahems
					3) errorPage : 에러가 있는 경우에 이동하는 파일 지정
					taglib => <%%> 를 제거하기 위해 제작된 태그
							=> for / if => 제어문을 태그로 제작
							=> 자바는 시용하지 않고 태그형 문법을 사용한다
		자바 표현법 : <% %> : JSTL -> 태그형 (제어문) <c:forEach>, <c:if> ...
		 			└ 일반 자바 코딩 : 제어문, 연산자, 메소드 호출, 지역변수 선언
				  <%=%> : EL  -> ${}
				  	└ 데이터 출력 :out.print()
				  
		내장객체 :  
			HttpServletRequest => request
			  => 브라우저 정보
			  http://localhost:8080/JSPBasicTotal/total/total_1.jsp    => 이 전체를 URL 
			  ====	 =============  ===============================  URI
			protocol  서버 IP			============= ContextPath
			  		  				
			  	1) getRequestURI()
			  	2) getContextPath()
			  	3) getRequestURL()
			  	4) getRemoteAddr() : 사용자의 IP 를 얻어온다
			  = 사용자 요청 정보
			  	1) getParameter() : 사용자가 보내준 단일 데이터 값
			  	2) getParameterValues() : String[]
			  					=> 한번에 여러개 값을 받을 경우 : checkbox
			  	3) setCharacterEncoding() : 디코딩
			  					=> POST방식일때 한글 변환
			  = 데이터 추가 정보
			   ===========================================
				1) setAttribute() : request에 데이터를 추가
				2) getAttribute() : 추가된 데이터를 읽어 올때 사용
			   =========================================== ${a}=> 일반변수 (X)
			   			=> <%= request.getAttribute("a")%>
			  = 기타
			  	getSession() : 생성된 session을 얻어오는 경우
			  	getCookies() : 생성된 쿠키의 데이터를 얻어 온다
			HttpservletResponse => response
				= 헤더 정보 : 다운로드 => 실제 데이터 전송 전에 먼저 보내는 값
				   	setHeader()
				= 이동 정보 
					sendRedirect() => GET 방식만 사용이 가능
				= 쿠키 저장
					addCookie()
			HttpSession => session
				= 저장 => setAttribute()
				= 읽기 => getAttribute()
				= 일부 삭제 => removeAttribute()
				= 전체 삭제 => invalidate() => 로그아웃시 사용
				= 세션 구분 => getId() => webchat
				= 기간 설정 => setMaxInactiveInterval(초 단위) => 기본 30분
			ServletContext => application
				= 이미지 올릴때 (상품등록, 갤러리 게시판)
					=> 바로 확인 : getRealPath()
			PageContext => pageContext
							request 제어 => 공유
							===================
							include() / forward()
							=> **** <jsp:include>
							=> <jsp:forward> : MVC구조에서 사용
			기타 : Cookie => 사용자 브라우저에 저장 (문자열만 저장이 가능)
				1. 생성
					Cookie cookie=new Cookie (키,값)
				2. 기간
					cookie.setMaxAge(초)
						=> setMaxAge(0) -> 0을 주면 삭제
				3. 저장위치
					cookie.setPath("/")
				4. 브라우저 전송
					response.addCookie(cookie)
				5. 쿠키 읽기
					Cookie[] cookies=request.getCookies()
				6. 키 읽기
					cookie.getName()
				7. 데이터 읽기
					cookie.getValue()
			=> Cookie 같은 경우 보안이 취약하기 때문에 => 최근 방문 / 자동 로그인 정도에 쓰임
		JSP액션태그
			=> <jsp:include>, <jsp:useBean> : 객체 생성
				=========== JSP안에 다른 JSP 포함
		데이터베이스 연동
			JDBC => DBCP => ORM(MyBatis/JPA)
					====
			1. 드라이버 등록
			2. 오라클 연결
			3. SQL 문장 생성 => SQL 문장만 작성 => 자동 처리
			4. 오라클로 SQL 문장 전송
			5. SQL 문장 실행 요청 => 결과값
			6. 오라클 연결 해제
		=============================================
		DBCP : 데이터베이스 연결에 소모되는 시간을 줄인다
				connection의 객체 생성 갯수를 조절
				=> 미리 연결된 Connection 을 pool 안에 저장
				=> POOL 안에서 Connection 의 주소를 얻어온다
				=> Connection 사용
				=> POOL 안으로 반환
				=> 웹사이트 개발의 기본
				=> Mybtis / JPA 는 기본 설정 
		==============================================
		
		
					  
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