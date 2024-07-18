<%@page import="com.sist.dao.CartVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%
// 	sesstion
	List<CartVO> list=(List<CartVO>)session.getAttribute("cart");
	if(list==null)
		list=new ArrayList<CartVO>();
	
	String id=(String)session.getAttribute("id");
	
	request.setCharacterEncoding("UTF-8");
	String name=request.getParameter("name");
	String poter=request.getParameter("poster");
	String no=request.getParameter("no");
	String price=request.getParameter("price");
	String account=request.getParameter("account");
	
	CartVO vo=new CartVO();
	
	
	boolean bCheck=false;
	for(CartVO cvo:list){
		if(cvo.getNo()==vo.getNo() && id.equals(cvo.getId())){
			int acc=cvo.getAccount()+vo.getAccount();
			cvo.setAccount(acc); //수량 증가
			bCheck=true;
			break;
		}
	}
	if(bCheck==false){
		list.add(vo);
		session.setAttribute("cart", list);
	}
	// 이동
	response.sendRedirect("cart_list.jsp");
	
	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>