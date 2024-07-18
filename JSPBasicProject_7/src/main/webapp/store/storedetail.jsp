
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.dao.*,java.util.*"%>
<jsp:useBean id="dao" class="com.sist.dao.GoodsDAO"></jsp:useBean>
<jsp:useBean id="rdao" class="com.sist.dao.ReplyDAO"></jsp:useBean>
<%
	String id=(String)session.getAttribute("id");
	String no=request.getParameter("no");
	
	GoodsVO vo=dao.goodsDetailData(Integer.parseInt(no));
	List<ReplyVO> list = rdao.replyListData(Integer.parseInt(no),2);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
let u=0; // 전역변수 
// 변수 => var : let, const(상수형)
$(function(){ // main => window.onload=function(){}
	$('.updates').click(function(){
		$('.ups').hide();
		let rno=$(this).attr("data-no");
		if(u==0)
		{
			u=1;
			$(this).text("취소");
			$('#ups'+rno).show(); // document.getElementById("ups"+rno)
		}
		else
		{
			u=0;
			$(this).text("수정");
			$('#ups'+rno).hide();
		}
	})
})
</script>
</head>
<body>
	<div class="row">
		<div class="col-sm-8">
			<table class="table">
				<tr>
					<td width="30%" class="text-center" rowspan="5">
						<img src="<%=vo.getPoster() %>" style="width: 100%">
					</td>
					<td colspan="2"><h3><%=vo.getName() %></h3>
				</tr>
				<tr>
					<th class="text-center" width="15">가격</th>
					<td width="55"><%=vo.getPrice() %></td>
				</tr>
				<tr>
					<th class="text-center" width="15">소개</th>
					<td width="55"><%=vo.getSub() %></td>
				</tr>

			</table>
		</div>
	</div>
</body>
</html>






