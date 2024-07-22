package com.sist.model;

import javax.servlet.http.HttpServletRequest;

import com.sist.dao.BoardDAO;
import com.sist.vo.BoardVO;

public class BoardUpdateModel implements Model {

	@Override
	public String execute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		// 수정하기
			String no = request.getParameter("no");
			BoardDAO dao = BoardDAO.newInstance();
			BoardVO vo = dao.boardUpdateData(Integer.parseInt(no));
			request.setAttribute("vo", vo);
		
		return "update.jsp";
		
	}

}
