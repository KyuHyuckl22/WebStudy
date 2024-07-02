package com.sist.dao;

import lombok.Data;

/*
 * 	자바 / 오라클 / JSP / Spring / Spring-Boot
 * 		   |
 *       JDBC / DBCP / MyBatis / JPA
 *       =================================== Back-End
 *	HTML / CSS 
 *  => 화면 제작, css 변경 정도만 알아도 괜찮음
 *  JavaScript : JQuery (AJAX) , VueJS , ReactJS , NodeJS , NextJS, NuxtJS
 *  ==========
 *  요즘엔 TypeScript 가 많이 뜨는 추세    
 *  
 */
/*
  이름                                      널?      유형
 ----------------------------------------- -------- ----------------------------
 FNO                                       NOT NULL NUMBER
 NAME                                      NOT NULL VARCHAR2(200)
 TYPE                                      NOT NULL VARCHAR2(200)
 PHONE                                              VARCHAR2(30)
 ADDRESS                                            VARCHAR2(700)
 SCORE                                              NUMBER(2,1)
 THEME                                              CLOB
 POSTER                                    NOT NULL VARCHAR2(260)
 CONTENT                                            CLOB
 HIT                                                NUMBER
 JJIMCOUNT                                          NUMBER
 LIKECOUNT                                          NUMBER
 */
@Data
public class FoodVO {
	private int fno;
	 private String name, type, phone, address, theme, poster, content;
	private double score;
}
