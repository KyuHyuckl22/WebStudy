package com.sist.dao;

import lombok.Data;

/*
FNO	NUMBER	No		1	
NAME	VARCHAR2(200 BYTE)	No		2	
TYPE	VARCHAR2(200 BYTE)	No		3	
PHONE	VARCHAR2(30 BYTE)	Yes		4	
ADDRESS	VARCHAR2(700 BYTE)	Yes		5	
SCORE	NUMBER(2,1)	Yes		6	
THEME	CLOB	Yes		7	
POSTER	VARCHAR2(260 BYTE)	No		8	
CONTENT	CLOB	Yes		9	
HIT	NUMBER	Yes	0	10	
JJIMCOUNT	NUMBER	Yes	0	11	
LIKECOUNT	NUMBER	Yes	0	12	
 */
@Data
public class FoodVO {
	private int fno,hit;
	private String name,type,poster;
}
