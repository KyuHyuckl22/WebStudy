<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" buffer="16kb"%>
<%--
	1. out
		=> 출력 버퍼 관리 객체명 => JsjpWriter
		   ====== HTML을 저장하는 메모리 공간
		   | JSP를 실행 요청 => 톰캣 => out.write() 를 메모리에 출력
		   | 브라우저에서 읽기			  ============
		   | 기본 저장공간 : 8kb       서블릿 out.write("<html>")
		  	==========		  JSP HTML앞에 out.write 를 생략
			HTML이 많거나 (상용된 사이트) => 크기를 변경할 수 있다.
			<%@ page buffer="16kb"%>
		=> 주요 메소드
			println() / print() / write() => HTML 저장용도 => <%= %>
																
			getBufferSize() : 버퍼의 크기를 확인
			getRemaining() : 남아있는 버퍼 크기 확인
		=> out 객체는 한번만 사용한다 => 다운로드
		   ======= <%= %> -변경-> ${}
		  *** 권장사항 : <%@~ 지시자를 제외하고 <% 제거한다 => HTML 과 Java를 섞지 않기 위함
		  	JSP 안에 자바 코딩을 하게되면 단점 1) 재사용을 할 수 없다 자바를 별도로 제작하면(재사용 가능, 수정/삭제 가 편리)
		  	MVC = (자바 따로, HTML 따로)
		  							 
	2. application
	
	3. pageContext
	4. page / config / exception (공부 불필요)
			 =>web.xml
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>전체 버퍼 크기 확인 : <%=out.getBufferSize() %> (8*1024)</h3>
	<h3>남아있는 버퍼 크기 확인 : <%=out.getRemaining() %> (8023)</h3>
	<h3>사용중인 버퍼 크기 확인 :<%=out.getBufferSize()-out.getRemaining() %> </h3>
	<br>
	<%
		out.print("<font color=red>Out(JspWriter)</font><br>");
		out.println("<font color=yellow>Out(JspWriter)</font><br>");
		out.write("<font color=green>Out(JspWriter)</font>");
	%>
	<br>
	<%="Out(JspWriter)" %><%-- out.print() 로 변환 : 권장사항 --%><br>
	<%-- ${ " Out(JspWriter)" }  EL --%>
</body>
</html>








