package com.sist.model;

import javax.servlet.http.HttpServletRequest;

public class InsertModel {
	public String execute(HttpServletRequest request) {
		String msg="게시물 추가";
		request.setAttribute("msg", msg);
		
		return "view/insert.jsp"; //request 의 값을 return 에 보내라
	}
}
