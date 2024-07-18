<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.vo.*"%>
<%
	SawonVO vo=new SawonVO();
	vo.setSabun(1);
	vo.setName("고길동");
	vo.setDept("개발부");
	vo.setJob("사원");
	vo.setPay(3000);
	
	request.setAttribute("vo1", vo); // ${} => request 나 sesstion 에 있는 값만 출력
	//					키 이름 
	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>EL => 객체 출력 방법</h1>
	사번 : <%= ((SawonVO)request.getAttribute("vo1")).getSabun() %><br>
	<%-- 위 코드를 줄여서 아래 코드처럼 사용 가능 --%>
	사번 :&#36;{vo1.sabun} => ${vo1.sabun }<br>
	이름 :&#36;{vo1.name} => ${vo1.name }<br>
	부서 :&#36;{vo1.dept} => ${vo1.dept }<br>
	직위 :&#36;{vo1.job} => ${vo1.job }<br>
	연봉 :&#36;{vo1.pay} => ${vo1.pay }<br>
</body>
</html>