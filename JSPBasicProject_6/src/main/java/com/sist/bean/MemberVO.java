package com.sist.bean;

import lombok.Data;
//   VO,     DTO,    Bean  == 3개 다 같은 개념
// Spring, MyBatis,   JSP  -> 데이터를 모아서 한번에 전송 할 목적
// 변수를 제어 => 읽기(Getter) / 쓰기(Setter) 두개의 기능밖에 없음.
//	데이터 해킹 방지를 위해 숨겨서 보내주는 방식 ==> 캡슐화 (데이터를 보호할 목적)
@Data
public class MemberVO {
	private String name, sex, address, phone;
}
