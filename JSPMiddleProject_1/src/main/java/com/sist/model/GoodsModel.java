package com.sist.model;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import com.sist.dao.*;

public class GoodsModel {
	public void GoodsListData(HttpServletRequest request) {
		String strPage=request.getParameter("page");
		if(strPage==null){
			strPage="1";
		}
		int curpage=Integer.parseInt(strPage); //현재 페이지
		GoodsDAO dao=GoodsDAO.newInstance();
		List<GoodsVO> list=dao.goodsListDataa(curpage);
		int totalpage=dao.goodsTotalPage();
		//BLOCK
		final int BLOCK=10;
		int startPage=((curpage-1)/BLOCK*BLOCK)+1; // 1~10 => 1  11~20 => 11
		int endpage=((curpage-1)/BLOCK*BLOCK)+BLOCK; // 1~10=>10 11~20 => 20
		if (endpage>totalpage)
			endpage=totalpage;
		
		//JSP 에서 출력할 데이터 전송
		request.setAttribute("list", list);
		request.setAttribute("curpage", curpage);
		request.setAttribute("totalpage", totalpage);
	}
	
	
}
