package com.sist.dao;

import java.util.Date;

import lombok.Data;
@Data
public class BoardVO {
	private int no,hit;
	private String name,subject,content,pwd;
	private Date regdate;
	private int group_id;	// 같은 답변을 모아서 관리
	private int group_step; // 답변 순서 지정
	private int group_tab; 	// 공백
	private int root;		// 어떤 게시물에 대한 답변인지 확인 
	private int depth;		// 게시물 몇개의 답변이 있는지 확인
	// 관리자 / 사용자 => 묻고 답하기 
}
