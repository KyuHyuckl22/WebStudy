package com.sist.dao;
/*
  이름                                      널?      유형
 ----------------------------------------- -------- ----------------------------
 NO                                        NOT NULL NUMBER
 ID                                                 VARCHAR2(20)
 SUBJECT                                   NOT NULL VARCHAR2(1000)
 MSG                                       NOT NULL CLOB
 DAY                                       NOT NULL VARCHAR2(20)
 REGDATE                                            DATE
 */

import java.sql.Date;

import lombok.Data;
@Data
public class DiaryVO {
	private int no,year,month,day;
	private String id,subject,msg,dbday;
	private Date regdate;
}
