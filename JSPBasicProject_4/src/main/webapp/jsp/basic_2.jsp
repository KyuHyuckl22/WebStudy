<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	JSP의 생명 주기 
	1. _jspInit() : web.xml 에 환결설정 == 생성자와 동일한 역할을 수행
	2. _jspservice() : doGet() / doPost() => 통합(조건문)
	  ============ JSP 에서 코딩한 소스가 메소드 안에 첨부
	  			  =============== _jspService()를 제작
	3. _jspDestory() : 메모리 해제.
	  public void _jspService(HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
		{
		PageContext pageContext;
    	HttpSession session = null;
    	ServletContext application;
    	ServletConfig config;
    	JspWriter out = null;
    	Object page = this;
		==========================================
				 여기가 우리가 실제 JSP코딩하는 위치
				 JSP는 클래스 영역이 아니라 => _jspService() 영역에서 코딩
		==========================================
		}
		
	=> 자바 정리 => 오라클 SQL 정리 => HTML / CSS 정리	
	113p  JSP 기초
	JSP 스크립트에 대한 이해
	1) JSP는 Java+HTML이 혼합
	             ===== CSS / JavaScript 포함
	   => 언어별 구분이 가능해야 한다
	   <%%> 	: 스크립트릿 => 일반 자바 코딩
	   						변수 선언 => 지역변수
	   						메소드 호출
	   						클래스 메모리 할당
	   						제어문 / 연산자
	   <%= %> 	: 표현식 => 브라우저 출력담당 out.print()
	   <%! %>	: 선언식 => 사용 빈도는 거의 없다
	   					  메소드를 JSP 에서 만드는 경우
	   class basic_005f2_jsp extends HttpJspBase
	   {
	   =========================================
			멤버변수
			<%! %>
	   =========================================
			생성자
			<
	   =========================================
			메소드
			public void _jspInit(){}
			public void 


	   =========================================
	   }
 --%>    
 <%--
 	public void _jspService(HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
  	{
  --%>
  <%!
  	String name;
  	public void display(){}
  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		int age=10;
	%>
	<%=age %><%-- out.print(age) --%>
</body>
</html>
 <%--
  	}
  --%>