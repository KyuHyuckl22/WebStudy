package com.sist.model;
/*
 * 
 *  MVC
 *  		HTTP요청(URL)		   웹 컨테이너 (톰캣)
 *  웹브라우저 ==============	====================
 *  |
 *  |						Controller
 *  |						1. 요청을 받는다 getRequestURI()
 *  |                       2. URI 를 이용해서 요청 내용 확인 => list.do, insert.do
 *  |                       3. 요청에 대한 처리 => Model이 가지고 있는 메소드를 호출
 *  |                       4. Model 에서 넘겨주는 request / session 가지고 온다
 *  |                       				  ======== request.setAttribute()
 *  |                        5. JSP 로 값을 전송 (forward=request 전송, sendRedirect()
 *  |                        
 *  |                       Model
 *  |                       1. 요청 처리
 *  |                       2. request / session 에 값을 담아준다
 *  |                       
 *  |                       DAO
 *  |                       1. 오라클 연동
 *  |                       2. 필요한 데이터를 가지고 온다
 *  |                       
 *  |                       오라클
 *  |                       1. 사이트에 필요한 공유 데이터를 모두 모아서 관리한다
 *  |                       
 *  |                       
 *  1. 브라우저 => URL을 이용해서 서버 연동 (주소창)
 *  2. URL을 이용해서 서버 연결이 되면 => Controller (URL 을 읽을 수 있는 프로그램 : JSP / Servlet)
 *  	=> 요청을 받아서 처리 => JSP로 결과값 전송 
 *   	   ============================== 화면 출력이 없이 연결 (서블릿)
 *   		JSP : Front-End (결과값을 받아서 출력)
 *  3. MVC 의 단점 --> Controller 에 집중적이다
 *  4. Controller : 역할(고정) => 소스 수정이 거의 없다
 *   				=> 필요한 데이터는 파일을 만들어서 전송
 *   				===========================
 *   				XML , Properties
 *  
 *  
 */
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.*;
import com.sist.dao.*;
import com.sist.vo.*;

import java.io.PrintWriter;
import java.text.*;
public class BoardModel {
	
	private BoardDAO dao=BoardDAO.newInstance();
	@RequestMapping("board/list.do")
	public String board_list(HttpServletRequest request, HttpServletResponse response) {
		//page 받기
		String page=request.getParameter("page");
		if(page==null)
			page="1";
		//정수형 변환 => 처리 가능
		int curPage=Integer.parseInt(page); 
		List<BoardVO> list=dao.boardListData(curPage);
		
/*
 * 		URL
 * 		==== 						 비교시
 *  	list.do				null값  	if(page==null)
 *  	list.do?page=		공백		if(page.equals(""))
 *  	list.do?page=1		1		
 */
		int count=dao.boardRowCount();
		//총 개시물 갯수
		int totalPage=(int)(Math.ceil(count/10.0));
		// 총 페이지
		count=count-((curPage*10)-10);
		
		//list.jsp 로 출력 데이터 전송
		request.setAttribute("list", list);
		request.setAttribute("curPage", curPage);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("count", count);
		
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String today=sdf.format(date);
		//SimpleDateFormat("yyyy-MM-dd").format(new Date());   이렇게 사용하면 한줄에 끝
		request.setAttribute("today",today);
		
		//                   main.jsp  에   include 가 되는 파일 지정
		request.setAttribute("main_jsp", "../board/list.jsp");
		return "../main/main.jsp";
				
	}
	@RequestMapping("board/insert.do")
	public String board_insert(HttpServletRequest request,HttpServletResponse response) {
		
		request.setAttribute("main_jsp", "../board/insert.jsp");
		return "../main/main.jsp";
	}
	@RequestMapping("board/insert_ok.do")
	public String board_insert_ok(HttpServletRequest request,HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		}catch(Exception ex) {}
		BoardVO vo=new BoardVO();
		vo.setName(request.getParameter("name"));
		vo.setSubject(request.getParameter("subject"));
		vo.setContent(request.getParameter("content"));
		vo.setPwd(request.getParameter("pwd"));
		// DataBase 연동 => DAO
		dao.boardInsert(vo);
		return "redirect:../board/list.do";
	}
	@RequestMapping("board/detail.do")
	public String board_detail(HttpServletRequest request,HttpServletResponse response) {
		
		String no=request.getParameter("no");
		// DAO 에서 상세보기에 출력할 데이터 읽기
		BoardVO vo=dao.boardDetailData(Integer.parseInt(no));
		request.setAttribute("vo", vo);
		request.setAttribute("main_jsp","../board/detail.jsp");
		return "../main/main.jsp";
	}
	@RequestMapping("board/update.do")
	public String board_update(HttpServletRequest request,HttpServletResponse response) {
		String no=request.getParameter("no");
		BoardVO vo=dao.boardUpdateData(Integer.parseInt(no));
		request.setAttribute("vo", vo);
		request.setAttribute("main_jsp", "../board/update.jsp");
		return "../main/main.jsp";
	
	}
	@RequestMapping("board/update_ok.do")
	public void board_update_ok(HttpServletRequest request,HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		}catch(Exception ex) {}
		BoardVO vo=new BoardVO();
		vo.setName(request.getParameter("name"));
		vo.setSubject(request.getParameter("subject"));
		vo.setContent(request.getParameter("content"));
		vo.setPwd(request.getParameter("pwd"));
		String no=request.getParameter("no");
		vo.setNo(Integer.parseInt(no));
		
		boolean bCheck=dao.boardUpdate(vo);
		
		try {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			if(bCheck==true) {
				out.write("<script>");
				out.write("location.href=\"../board/detail.do?no="+no+"\"");
				out.write("</script>");
			}else {
				out.write("<script>");				
				out.write("alert(\"비밀번호가 틀립니다\");");
				out.write("history.back()");
				out.write("</script>");
			}
		}catch(Exception ex) {}
		
	}
	@RequestMapping("board/delete.do")
	public String board_delete (HttpServletRequest request, HttpServletResponse response) {
		
		request.setAttribute("no", request.getParameter("no"));
		request.setAttribute("main_jsp", "../board/delete.jsp");
		return "../main/main.jsp";
	}
	@RequestMapping("board/delete_ok.do")
	public String board_delete_ok (HttpServletRequest request, HttpServletResponse response) {
		String no=request.getParameter("no");
		String pwd=request.getParameter("pwd");
		
		boolean bCheck=dao.boardDelete(Integer.parseInt(pwd), pwd);
		
		try {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			if(bCheck==true) {
				out.write("<script>");
				out.write("location.href=\"../board/list.do\"");
				out.write("</script>");
			}else {
				out.write("<script>");				
				out.write("alert(\"비밀번호가 틀립니다\");");
				out.write("history.back()");
				out.write("</script>");
			}
			
		}catch(Exception ex) {}
		return "";
	}
}













