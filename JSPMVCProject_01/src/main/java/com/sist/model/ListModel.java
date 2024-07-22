package com.sist.model;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/*
 *  MVC => HTML 과 Java 를 분리하는 작업
 *  	=> 분업화 / 확장성이 좋다 / 재사용이 용이
 *  	=> 실제 실무에서는 MVC만 사용
 *  	    => MVC 의 단점 : 소스가 복잡하다 / Controller 에 의존하는 경향이 많다 /
 *  								   ===========================
 *  										└> Controller 를 여러개 사용 : 도메인 방식
 *  	=> Spring => MVC Project : MVC 만 사용이 가능
 *  	
 *  MVC 
 *  	= Model : 자바와 관련된 모든 소스
 *  		- 영역 : 사용자 요청에 따른 데이터 관리
 *  			DAO, VO, Service, Manager
 *  	= View : JSP / HTML / CSS / JavaScript => 중심을 태그형 프로그램에 두고 있다
 *  		- 영역 : 화면 출력 (Model 에서 전송한 데이터를 출력
 *  			<% %> <%= %> (사용하지 않는다)
 *  			<c:forEach> <c:if> %{} 로 사용
 *  	= Controller : Model과 View 를 연결하는 역할
 *  		=> Servlet 으로 제작되어 있다 (스프링에서 이미 제작 => 서블릿)
 *  
 *  MVC 실행 과정
 *   	1. JSP(요청) => <a>,<form>, ajax, javascript
 *   	*** JSP에서 요청 (URL로 요청) => 받을 수 있는 파일
 *   							   ============
 *   								서블릿, JSP 로 받을 수 있다
 *      2. Controller 가 요청값을 받는다
 *      	1) 요청값을 받는다
 *      		└ request, response 전송
 *      	2) 해당 Model 을 찾는다
 *      	3) 받아서 출력할 JSP를 찾는다
 *      	4) JSP => request 를 전송
 *      		└ forward() 를 이용한다 => request를 전송한다
 *      	============================================
 *       	모든 화면은 Controller 다 => .do (서블릿을 나타낸다)
 *       	JSP 화면만 갱신
 *      3. JSP에 화면을 출력하고 Controller 에 덮어 쓴다
 *      	>> 시작과 끝은 Controller (.do~  .do) => 모든 URL 주소는 .do => 서블릿을 찾을 때 사용
 *      		request				request			
 *      	JSP =======> Controller =======> Model =======> DAO
 *      	 ^												 |
 *      	 └  <======= Controller <======= Model <======= <┘
 *      		request 			request 에 값을 담는다
 *      
 *      list.jsp	=> 자바/HTML을 혼합		==> list.jsp / ListModel.java
 *      insert.jsp						==> insert.jsp / InsertModel.java
 *      update.jsp						==> update.jsp / UpdateModel.java
 *      delete.jsp						==> delete.jsp / DeleteModel.java
 *      								==================================  합쳐주는 역할 = Controller
 *      
 */
public class ListModel {
	public String execute(HttpServletRequest request) {
		String msg="게시판 목록";
		request.setAttribute("msg", msg);
		
		return "view/list.jsp"; //request 의 값을 return 에 보내라
	}
}






