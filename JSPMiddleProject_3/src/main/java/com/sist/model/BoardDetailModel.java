package com.sist.model;

import javax.servlet.http.HttpServletRequest;

import com.sist.dao.BoardDAO;
import com.sist.vo.BoardVO;

public class BoardDetailModel implements Model {

	// 상세보기
	public String execute(HttpServletRequest request) {
		String no = request.getParameter("no");
		BoardDAO dao = BoardDAO.newInstance();
		BoardVO vo = dao.boardDetailData(Integer.parseInt(no));

		request.setAttribute("vo", vo);
		return "detail.jsp";
				
	}
}
