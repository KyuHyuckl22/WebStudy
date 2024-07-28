package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 *  관련 클래스가 많은 경우 : 한 개로 모아서 처리 => 인터페이스
 *  
 *  1. 여러개 => 한 줄로 묶음 
 *  	변수 여러개 => 배열
 *  	클래스 여러개 => 인터페이스
 *  2. 메소드 여러개 => 구분자 (임의로 결정, 제공하는 구분자)
 *  					========
 *  					1. a()
 *  					2. b()
 *  					3. c() ...     (가독성이 떨어진다)
 *  									======보 완======> 어노테이션
 *  
 *  1. 재사용, 확장성, 가독성, 최적화 , 접근성이 좋아야 함  
 *     ===================== 초점을 맞춰야 하는 부분
 *     
 *     
 */
public class MovieDetailModel implements Model {
	@Override
	public String execute(HttpServletRequest request,HttpServletResponse response) {
		
		return null;
	}
}










