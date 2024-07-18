<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.sist.dao.*"%>
<%--
	자바로부터 데이터를 읽어온다
 --%>    
 <%
 	// 1. 사용자로부터 페이지 번호를 받는다
 	String strPage=request.getParameter("page");
 	if(strPage==null) // 처음 실행시에는 사용자로부터 페이지를 받지 못한다 => 디폴트 페이지 생성
 			strPage="1";
 	// 현제 페이지 설정
 	int curpage=Integer.parseInt(strPage);
 	// 오라클로부터 해당 페이지의 데이터를 읽어온다
 	DataBoardDAO dao=DataBoardDAO.newInstanct();
 	// <jsp:useBean id = "dao" class="DataBoardDAO">  => 이 코딩은 MVC 구조로 넘어가게 되면 사라진다
 	// 													Spring 은 MVC 로 되어있다
 	List<DataBoardVO> list=dao.databoardListData(curpage);
 	int count=dao.databoardRowCount(); // 번호를 순차적으로 출력
 	int totalpage=(int)(Math.ceil(count/10.0)); // 실제 총 페이지
 	// 번호 변경
 	count=count-((curpage*10)-10); //다음페이지 갈때 마다 10 씩 빼준다
 	// Model (Java => 메소드화) => 브라우저로 전송(Controller) => 받아서 화면출력(View)
 	// 소스는 변경사항이 없음 => 자바 / HTML 분리
 	// JSP 에서 사용된 자바는 태그형으로 변경이 된다
 	// for() =이렇게 변경=> <c:forEach>   / /  if() =이렇게 변경=> <c:if> switch =이렇게 변경=> <c:choose> ...
 	// sendRedirect() =이렇게 변경=> <c:redirect> => JSTL => tahlib => 20장 
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
	margin-top : 50px;
}
.row{
	margin: 0px auto;
	width : 800px;
}
h3{
	text-align: center;
}
</style>
</head>
<body>
	<div class="container">
		<h3>자료실</h3>
		<div class="row">
			<table class="table">
				<tr>
					<td>
						<a href="insert.jsp" class="btn btn-sm btn-primary">새글</a>
					</td>
				</tr>
			</table>
			<table class="table table-hover">
				<thead>
					<tr class="danger">
						<th width=10% class="text-center">번호</th>
						<th width=45% class="text-center">제목</th>
						<th width=15% class="text-center">이름</th>
						<th width=20% class="text-center">작성일</th>
						<th width=10% class="text-center">조회수</th>
					</tr>
				</thead>
				<tbody>
					<%
						for(DataBoardVO vo:list){
					%>
						<tr>
							<td width=10% class="text-center"><%=vo.getNo() %></td>
							<td width=45%>
							<%--
								실제 게시물 번호를 전송 : 번호에 해당되는 데이터를 가지고 와서 출력
								상세보기 = 무조건 Primary key 를 전송
							 --%>
							<a href="detail.jsp?no=<%=vo.getNo() %>"><%=vo.getSubject() %>
								<%
									String today=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
									if(today.equals(vo.getDbday())){
								%>
									&nbsp;<sup style="color:red">new</sup>
								<%		
									}
								%>
								</a>
							</td>
							<td width=15% class="text-center"><%=vo.getName() %></td>
							<td width=20% class="text-center"><%=vo.getDbday() %></td>
							<td width=10% class="text-center"><%=vo.getHit() %></td>
						</tr>
					<%		
						}
					%>
				</tbody>
			</table>
			<table class="table">
				<tr>
					<td class="text-center">
						<a href="list.jsp?page=<%=curpage>1?curpage-1:curpage %>" class="btn btn-sm btn-success">이전</a>
						<%=curpage %> page / <%=totalpage %> pages
						<a href="list.jsp?page=<%=curpage<totalpage?curpage+1:curpage %>" class="btn btn-sm btn-info">다음</a>
					</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>




