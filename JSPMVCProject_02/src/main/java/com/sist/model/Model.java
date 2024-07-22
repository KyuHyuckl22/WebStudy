package com.sist.model;

import javax.servlet.http.HttpServletRequest;
//	처리하는 기능이 비슷한 경우 => 클래스를 통합 => 그때 사용하는게 인터 페이스 
//	인터페이스를 사용하면 조건문 없이 찾을 수 있다. (수정시 용이)
public interface Model {
	public String execute(HttpServletRequest request);
}
