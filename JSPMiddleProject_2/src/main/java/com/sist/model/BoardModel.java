package com.sist.model;

import java.io.PrintWriter;
import java.net.http.HttpRequest;
import java.text.SimpleDateFormat;
//	요청처리 후에 결과값을 JSP로 전송 : Model
//  오라클 연결 / 데이터를 모은다 / 전송
//    DAO         VO       Model ==> Model (Back-End)
import java.util.*;

import javax.naming.Context;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.*;

/*
 *  JSP 파일  ==> request를 가지고 있다
 *  <@ page ~ %>
 *  <%
 *  	데이터 읽기      => 이 부분이 자바 파일로 제작
 *  %>
 */
/*
 *  JSP ===> Java
 *  JSP ===> JSP
 *  JSP ===> Servlet
 */
public class BoardModel {
	// request 에 값 채워주기 => 요청처리하는 부분
	public void boardListData(HttpServletRequest request) {
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
	}

	// 글쓰기 처리
	public void boardInsertOk(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (Exception ex) {
		}
		String name = request.getParameter("name");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		String pwd = request.getParameter("pwd");

		BoardVO vo = new BoardVO();
		vo.setName(name);
		vo.setSubject(subject);
		vo.setContent(content);
		vo.setPwd(pwd);

		BoardDAO dao = BoardDAO.newInstance();
		dao.boardInsert(vo);

		try {
			response.sendRedirect("list.jsp");
		} catch (Exception ex) {
		}

	}

	// 상세보기
	public void boardDetailData(HttpServletRequest request) {
		String no = request.getParameter("no");
		BoardDAO dao = BoardDAO.newInstance();
		BoardVO vo = dao.boardDetailData(Integer.parseInt(no));

		request.setAttribute("vo", vo);
	}

	// 수정하기
	public void boardUpdateData(HttpServletRequest request) {
		String no = request.getParameter("no");
		BoardDAO dao = BoardDAO.newInstance();
		BoardVO vo = dao.boardUpdateData(Integer.parseInt(no));
		request.setAttribute("vo", vo);
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
	
	public void boardDeleteOk(HttpServletResponse response, HttpServletRequest request) {
		String no=request.getParameter("no");
		String pwd=request.getParameter("pwd");
		
		BoardDAO dao=BoardDAO.newInstance();
		boolean bCheck=dao.boardDelete(Integer.parseInt(no), pwd);
		
		try {
			if(bCheck==true) {
				
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
