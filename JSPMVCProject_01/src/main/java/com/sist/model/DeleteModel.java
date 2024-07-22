package com.sist.model;

import javax.servlet.http.HttpServletRequest;

public class DeleteModel {
	public String execute(HttpServletRequest request) {
		String msg="게시물 삭제";
		request.setAttribute("msg", msg);
		
		return "view/delete.jsp"; //request 의 값을 return 에 보내라
	}
}
