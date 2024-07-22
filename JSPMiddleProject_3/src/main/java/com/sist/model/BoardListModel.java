package com.sist.model;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.BoardDAO;
import com.sist.vo.BoardVO;

public class BoardListModel implements Model{
	
	public String execute(HttpServletRequest request) {
		String page = request.getParameter("page");
		if (page == null)
			page = "1";

		int curpage = Integer.parseInt(page);

		BoardDAO dao = BoardDAO.newInstance();
		List<BoardVO> list = dao.boardListData(curpage);

		int totalPage = dao.boardTotalPage();
		// list.jsp로 출력에 필요한 데이터 전송
		request.setAttribute("list", list);
		request.setAttribute("totalpage", totalPage);
		request.setAttribute("curpage", curpage);

		request.setAttribute("today", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		return "list.jsp";
	}






	public void boardUpdateOk(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		}catch(Exception ex) {}
		String name=request.getParameter("name");
		String subject=request.getParameter("subject");
		String content=request.getParameter("content");
		String pwd=request.getParameter("pwd");		
		String no=request.getParameter("no");
		
		BoardVO vo=new BoardVO();
		vo.setName(name);
		vo.setSubject(subject);
		vo.setContent(content);
		vo.setPwd(pwd);
		vo.setNo(Integer.parseInt(no));
		 
		BoardDAO dao= BoardDAO.newInstance();		
		boolean bCheck=dao.boardUpdate(vo);
		
		try {
			if(bCheck==true) {
				response.sendRedirect("detail.jsp?no="+no);
			}else {
				PrintWriter out=response.getWriter();
				out.write("<script>");
				out.write("alert(\"비밀번호가 틀립니다\");");
				out.write("history.back();");
				out.write("</script>");
			}
		}catch(Exception ex) {}
	}

}
