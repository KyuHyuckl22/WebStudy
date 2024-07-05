package com.sist.dao;

import lombok.Data;

/*
 *   자바 / 오라클 / JSP / ***Spring / ***Spring-Boot 
 *          | JDBC / DBCP / ***MyBatis / JPA 
 *   ======================================== Back-End (추천 => 85%)
 *   HTML / CSS 
 *     => 화면 제작 , CSS 변경 
 *   JavaScript : JQuery (AJAX) , **VueJS , **ReactJS , NodeJS , NextJS , NuxtJS
 *   =========== TypeScript 
 *   
 *   FNO                                       NOT NULL NUMBER
	 NAME                                      NOT NULL VARCHAR2(200)
	 TYPE                                      NOT NULL VARCHAR2(200)
	 PHONE                                              VARCHAR2(30)
	 ADDRESS                                            VARCHAR2(700)
	 SCORE                                              NUMBER(2,1)
	 THEME                                              CLOB
	 POSTER                                    NOT NULL VARCHAR2(260)
	 CONTENT                                            CLOB
 */
/*
 * 	desc table_name; 확인
 * 	
 * 	변수명과 컬럼명 동일
 *  => 데이터를 브라우저로 전송할 목적 으로 만든것 VO (~DTO) , JSP 에서는 (Bean)  => 자바책 12장에 나오는 내용
 *     ==================== (데이터를 넘길때 데이터를낚아챔(해킹) 이 될수 있다 그렇기에 캡슐화 방식을 써야 한다
 *       └ 캡슐화 사용 => 변수 (private), 메소드를 이용해서 접근
 *     데이터형을 일치 시켜야 한다
 *     ================== 테이블 한개에는 VO / DAO 가 필요하다 
 *     오라클 데이터형
 *     ========== CHAR, VARCHAR2, CLOB 이 나오면 String 으로 받는다
 *     			  NUMBER 가 나오면 2가지 경우의 수가 있다. int , double
 *     			  DATE 는 java.util.Date(java,sql.Date)
 *                       => 오늘 날짜를 집어넣을때는 SYSDATE 사용
 *                       - 예약일 : YY/MM/DD => TO_DATE로 변환후에 INSERT
 *  VO => 한개의 맛집
 *        ======= 상세보기
 *  목록 => 여러개의 맛집
 *  	  ========= VO가 여러개 : List가 필요
 *  MyBatis / JPA => 컬럼이 다르면 변경
 *  조금 길더라도 컬럼명을 변수명으로 가는게 좋다
 *  
 *                
 *  
 */
@Data
public class FoodVO {
   private int fno;
   private String name,type,phone,address,theme,poster,content;
   private double score;
}









