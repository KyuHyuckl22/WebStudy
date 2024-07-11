<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="row">
	  <h3 class="text-center">Request 객체</h3>
		<table class="table">
			<tr>
				<th width="20%">클래스명</th>
				<td width="80%">httpServletRequest</td>
			</tr>
			<tr>
				<th width="20%">기능</th>
				<td width="80%">
					<ul>
						<li>헤더정보</li>
						<li>화면이동</li>
						<li>전송형식</li>
					</ul>
				</td>
			</tr>
			<tr>
				<th width="20%">주요 메소드</th>
				<td width="80%">
					<ul>
						<li>void setHeader (String send):다운로드시 사용 => 먼저 전송값</li>
						<li>void sendRedirect(String url): 화면 이동 => request가 초기화</li>
						<li>void setContentType(String mim)</li>
						<li></li>
						<li></li>
						<li></li>
						<li></li>
					</ul>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>