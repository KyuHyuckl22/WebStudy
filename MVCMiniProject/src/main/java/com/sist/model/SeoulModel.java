package com.sist.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.LocationDAO;
import com.sist.vo.LocationVO;

import controller.RequestMapping;

public class SeoulModel {
	@RequestMapping("seoul/list.do")
	public String seoul_list(HttpServletRequest request, HttpServletResponse response) {
		
		String page=request.getParameter("page");
		if(page==null)
			page="1";
		int curPage=Integer.parseInt(page);
		LocationDAO dao=LocationDAO.newInstance();
		List<LocationVO> list=dao.seoulListData(curPage);
		int totalPage=dao.seoulTotalPage();
		
		final int BLOCK=10;
		int startPage=((curPage-1)/BLOCK*BLOCK)+1;
		int endPage=((curPage-1)/BLOCK*BLOCK)+BLOCK;
		
		if(endPage>totalPage)
			endPage=totalPage;
				
		request.setAttribute("list", list);
		request.setAttribute("curPage", curPage);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		
		request.setAttribute("main_jsp", "../seoul/list.jsp");
		return "../main/main.jsp";
	}
	@RequestMapping("seoul/detail.do")
	public String seoul_detail (HttpServletRequest request,HttpServletResponse response) {
		
		request.setAttribute("main_jsp", "../seoul/detail.jsp");
		return "../main/main.jsp";
	}
	
	
	
}
















