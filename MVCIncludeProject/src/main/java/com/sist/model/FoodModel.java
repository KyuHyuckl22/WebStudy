package com.sist.model;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.FoodDAO;
import com.sist.dao.FoodVO;
import com.sist.dao.MusicDAO;
import com.sist.dao.MusicVO;

import controller.*;
public class FoodModel {
	  @RequestMapping("food/list.do")
	  public String foodlist(HttpServletRequest request,HttpServletResponse response)
	  {
		  String page=request.getParameter("page");
		  if(page==null)
			  page="1";
		  int curpage=Integer.parseInt(page);
		  FoodDAO dao=FoodDAO.newInstance();
		  List<FoodVO> list=dao.foodListData(curpage);
		  int totalpage=dao.foodTotalPage();
		  
		  request.setAttribute("curpage", curpage);
		  request.setAttribute("totalpage", totalpage);
		  request.setAttribute("list", list);
		  request.setAttribute("main_jsp", "../food/list.jsp");//include
		  return "../main/main.jsp";
	  }
	  @RequestMapping("food/detail.do")
	  public String fooddetail(HttpServletRequest request,HttpServletResponse response)
	  {
		  String mno=request.getParameter("mno");
		  FoodDAO dao=FoodDAO.newInstance();
		  FoodVO vo=dao.foodDetailData(Integer.parseInt(mno));
		  request.setAttribute("vo", vo);
		  request.setAttribute("main_jsp", "../food/detail.jsp");
		  return "../main/main.jsp";
	  }
}