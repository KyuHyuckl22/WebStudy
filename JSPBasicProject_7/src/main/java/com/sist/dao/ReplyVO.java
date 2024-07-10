package com.sist.dao;
import java.util.*;

import lombok.Data;

@Data
public class ReplyVO {
	private int rno;
	private String id,name,msg;
	private Date regdate;
}
