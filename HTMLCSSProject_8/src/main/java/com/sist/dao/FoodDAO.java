package com.sist.dao;
import java.util.*;

import javax.naming.spi.DirStateFactory.Result;

import java.sql.*;
import com.sist.database.*;
public class FoodDAO {
	private Connection conn; //연결담당
	private PreparedStatement ps; //sql 문장 송수신 => sql문장 전송 / 결과값을 받는다
	private static FoodDAO dao; // 싱글턴
	private DataBaseConnection dbconn=new DataBaseConnection();
	
	public static FoodDAO newInstance() {
		if(dao==null)
			dao=new FoodDAO();
		return dao;
	}
	// 기능
	// 메소드를 만들때는 결과 값을 어떻게 할 것인가? 
	// 결과값이 브라우저로 넘어간다.  사용자 요청은 무엇인가?
	// 사용자가 페이지를 선택하면 오라클에 저장된 데이터중 페이지에 해당되는 데이터를 보낸다
	// 화면 목록 출력 => list
	// 상세보기 => vo
	
	public List<FoodVO> foodListData(int page){
		List<FoodVO> list=new ArrayList<FoodVO>();
		try {
			conn = dbconn.getConnection();
			String sql="SELECT fno, poster, name, num "
					 + "FROM (SELECT fno, poster, name, rownum as num "
					 + "FROM (SELECT /*+ INDEX_ASC(food_house fh _fno_pk)*/fno, poster, name "
					 + "FROM food_house)) "
					 + "WHERE num BETWEEN ? AND ? ";
			ps=conn.prepareStatement(sql);
			int rowSize=12;
			int start=(rowSize*page)-(rowSize-1);
			int end=rowSize*page;
			ps.setInt(1, start);
			ps.setInt(2, end);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				FoodVO vo= new FoodVO();
				vo.setFno(rs.getInt(1));
				vo.setPoster(rs.getString(2));
				vo.setName(rs.getString(3));
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			dbconn.disConnection(conn, ps);
		}
		return list;
	}
	public int foodTotalPage() {
		int total=0;
		try {
			conn=dbconn.getConnection();
			String sql="SELECT CELL(COUNT(*)/12.0) FROM food_house "; // 이문장 sql에 적기
			// 전송
			ps=conn.prepareStatement(sql);
			// 결과값 받기
			ResultSet rs=ps.executeQuery(); // 엔터치기
			rs.next();
			total = rs.getInt(1);
			rs.close();
		}catch(Exception ex ) {
			ex.printStackTrace();
		}finally {
			dbconn.disConnection(conn, ps);
		}
		return total;
	}
	
}
