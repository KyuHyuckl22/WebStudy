<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	JSP 란 java sever page 의 약자 => 서버에서 실행하는 자바 파일 => Back-End
	Back-End : Java, JSP, Servlet, Spring, Oracle
	Front-End : HTML, CSS, JavaScript
	                      ============ 라이브러리로 자주 사용 
    JSP 
      1. HTML + Java  이 두개가 섞여있다. 
        - 구분 
          자바 =>  <% %> , <%= %> , <%! %>
                 스크리트릿   표현식      선언문    - 선언문은 잘 사용되지 않음
      2. 동작 방식 
        - 정적페이지  /  동적페이지
            |           └ 한개의 파일에 여러개의 데이터를 출력(JSP,PHP,ASP,CGI)
        한 파일에 한개만 사용(HTML)
      3. 지시자
        page : JSP파일에 대한 정보를 저장
               = 변환 content type
                 브라우저에서 실행 => HTML / XML / JSON
                 => HTML : text/html
                 => XML : text/xml
                 => JSON : text/json  =  JavaScript Object Nontation
                           자바스크립트 객체 표현법 => VO
                           => Ajax , VueJS , ReactJS , Redux ,Next ...
                           VO  =표현=> {}
                           List =표현=> [{},{}]... 
               = 라이브러리 : import
               = 한글 변환 : pageEnconding => UTF-8 (호환성)
               = 에러페이지 : errorPage="파일명"
                 1) 404 : 파일이 없는 경우
                    	  < a href = "파일명" >
                 2) 500 : 자바 컴파일 에러
                 ================================================
                 3) 403 : 접근 거부 (Spring-Security)
                 4) 412 : 한글 변환 코드문제 (UTF-8 을 UFT-8 로 적는 경우) 
                 5) 400 : bad request => 전송값과 받는 데이터 형이 다른 경우 발생
        include : <%@ include file="" %> => <iframe>
         		 JSP 안에 다른 JSP 를 포함할때 사용
         		 ================================ 
   							로고/메뉴/검색				--------|  변경되지 않는 부분
         		 ================================ 			|  모든 파일에 고정.
   						|				|					|  하나의 파일로 만들어 놓는다
   						|				|					|  그리고 그것을 불러올때 
         		 ================================ 			|  include 를 사용한다.
   							개인정보 방침     			--------|
         		 ================================ 
        taglib : jsp 의 단점을 보완 =======> JSTL : 자바 / HTMl 을 분리할 때 사용
                자바 => 태그 형으로 변경               ===================== 자바와 HTML 을 분리하는 구조를 MVC 구조 라고 한다.
                <%														Spring 에서는 MVC 만 사용한다
                	if(조건문)				<c:if test="">					1차 프로젝트 => MVC 로 제작할 예정
                	
                	{					  HTML							ReactJS ==> Redux
                %>						</c:if>							(일반)        (MVC)
                	HTML 내용		=====>                                  VueJS   ==> Vuex
                <%
                	}
                %>  			
      4. 자바 코딩
        <% %> : 스크립트릿 : 일반자바 (메소드 안에 코딩)        						
        				 지역변수 선언, 제어문, 메소드 호출
        	  => 자바 문법을 그대로 사용
        	  => 주석 //    /**/
        <%= %> : 표현식 => 데이터를 화면에 출력 => out.write()
        								 out.println()
        <%! %> : 선언식 => 메소드, 멤버변수 사용
      5. 지원하는 라이브러리
        request / response / out / session / application
        =======   ========         =======   ===========
        config / exception / page / pageContext
                                    ============ include / foreward : 흐름
      6. Cookie VS Session
                    서버에 데이터 저장
        브라우저에 데이터 저장
      7. JSP 액션 태그 / 빈즈
                     ===== 데이터를 모아서 한번에 전송할 목적으로 만들어지는 프로그램 (java 에서 VO)
        <jsp:include>
        <jap:useBean>
      8. JSTL / EL => 제어문 / 메소드 호출 을 태그로 제작 
        ====================================== MVC 
         (교제는 여기까지. 이 아래는 중급과정) 
      9. MVC  
      10. Spring
        
  JSP  12장까지 공부 후 20,21 장으로 넘어감 / 예제들은 책에 나온대로 코딩이 아니라 용용 식으로 변형
	18p
	  1. 웹 동작
	    ======= 클라이언트의 요청 (request), 서버에서 요청에대한 응답 (response)
	            => C/S => Client / Server
	      요청시 => URL 주소를 이용한다
	              브라우저=> 주소창 (유일하게 서버와 연결)
	              http://localhost:8080/JSPBasicProject_1/jsp/basic_1.jsp
	              ================      =================================
	              서버주소(서버정보) 				    사용자가 요청하는 부분 => URI
	                   |                          (파일을 보여달라)
	                 생략하는 경우 => Welcome 파일을 등록해야 한다
	                 파일의 확장자는 개발자가 설정할 수 있다
	                 .naver / .daum / .do ...
	                 PathVariable => 요즘 많이 사용 (파일명인지 변수값인지 알 수 없게 만들어줌)
	19p                     
	    ===================================================================
		브라우저 (클라이언트) : 크롬 / IE / FF
		웹서버 : Apache / IIS
		웹애플리케이션 / WAS  : tomcat => JSP 를 자바로 변경 => 브라우저 HTML을 전송  
	(Web Application Server)
		데이터베이스 : 오라클
		===================================================================
							 파일 요청 						  	  Was(tomcat)
	  client (브라우저) ========================== Web Server ================>
	     										Apache / IIS		|
	     										     |	      .jsp => java로 변경                                 
                                                 요청 파일 확인 				|
                                                 => .html / .xml	   컴파일
                                                 => 자체처리   			   .class
                                                 						|
                                                 						한 줄씩 번역
                                                 						|
                                                 						HTML만 메모리에
                                                 						|
                                         =================================
                                           브라우저가 읽어 갈 수 있게 만든다
      파일
      정적 페이지 : HTML / CSS => 데이터 갱신이 불가능
      동적 페이지 : JSP / JavaScript => 데이터를 갱신
      ========= CGI, ASP, PHP
      ========= 22p
               Servlet / JSP
               =======
               Server + let => 서버에서 실행되는 가벼운 프로그램 : .java
                   => 자바에서 처음 웹 프로그램의 시작
                   => 단점 : 변경시에 컴파일 => 실행
                   => 바로 변경된 소스를 확인이 불가능
                   ========================= 바로 확인(적용) => JSP 
                   = 장점 : 보안이 뛰어나다 (.class 배포)
                           보안과 관련된 웹 파일 => 서블릿으로 제작
                           => JSP는 주로 화면 출력
                   = 스프링이 서블릿으로 만들어져 있다
                     =====================
                     => JSP : 배포시에 소스를 그대로 전송 (소스가 노출된다)
                   = MVC
                     Model : 자바 (DAO, VO ...)
                     View : JSP (화면에만 출력 가능)
                     Controller : Model과 View 연결 => Servlet
               => JSP 파일 1 
                  =========
                  Java + HTML 분리 .  연결시 사용하는것 => 서블릿
                  ===============   
			   => 서블릿 => JSP 가 컴파일 되면 서블릿으로 변경
			              =========================== 톰캣
			   => 서블릿 => JSP => 서블릿 + JSP
			                    ===== 스프링 (라이브러리가 서블릿)
			                    
			       서블릿. JSP => Java+HTML
			       ======================
			       | HTML 만 이요해서 처리 => ThymeLeaf
			       
			       ThymeLeaf => JSP 보다 속도가 느리다 
			       |
			       서버 클라이언트를 나눠서 작업
			       ====================
			       서버 => BOOT
			             |
			       클라이언트는 Vue / React
			       
	    서블릿 => JSP => MVC => Spring => Spring-Boot
	                        |
	                      파이썬 => 장고 => React                
                                                 
                                                 
                                                 
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





