package com.sist.dao;

import lombok.Data;
/*
 *  request / respone / => sesstion / => cookid
 *  application / pageContext / out
 *  =========getRealPath()
 *  
 */
@Data
public class MemberVO {
	private String id, name, pwd, msg;
}
