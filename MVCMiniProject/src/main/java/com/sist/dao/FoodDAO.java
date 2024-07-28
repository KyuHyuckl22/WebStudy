package com.sist.dao;
import java.util.*;

import com.sist.vo.FoodVO;
import com.sist.vo.LocationVO;

import java.sql.*;
import dao.Dbcpconnection;
public class FoodDAO {
	private Connection conn;
	private PreparedStatement ps;
	private static FoodDAO dao;
	private Dbcpconnection dbconn=new Dbcpconnection();
	private final int ROWSIZE=20;
	public static FoodDAO newInstance() {
		if(dao==null)
			dao=new FoodDAO();
		return dao;
	}
	
	public List<FoodVO> foodTop12(){
		List<FoodVO> list=new ArrayList<FoodVO>();
		try {
			conn=dbconn.getConnection();
			String sql="SELECT fno,name,poster,rownum "
					  +"FROM (SELECT fno,name,poster "
					  +"FROM food_house ORDER BY hit DESC) "
					  +"WHERE rownum<=12" ;
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				FoodVO vo=new FoodVO();
				vo.setFno(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setPoster(rs.getString(3));
				
				list.add(vo);
			}
			rs.close();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			dbconn.disConnection(conn, ps);
		}
		
		return list;
	}
	// 목록 출력
/*
 *  Controller 는 이미 제작 완료 (스프링)
 *  => 웹
 *  	1. 요청 => 어떤 값을 보낼지
 *  			<a> => ? key=value   => request.getParameter()
 *  					 ========== 
 *  	2. 어떤 JSP에 어떤 결과를 보내줄지     => request.setAttribute()
 *  	3. 데이터베이스 (SQL 문장)
 */
	public List<FoodVO> foodListData(int page){
		List<FoodVO> list=new ArrayList<FoodVO>();
		try {
			conn=dbconn.getConnection();
			String sql="SELECT fno,name,poster,num "
					  +"FROM (SELECT fno,name,poster,rownum as num "
					  +"FROM (SELECT fno,name,poster "
					  +"FROM food_house ORDER BY fno ASC)) "
					  +"WHERE num BETWEEN ? AND ? ";
			ps=conn.prepareStatement(sql);
			
			int start=(ROWSIZE*page)-(ROWSIZE-1);
			int end=ROWSIZE*page;
			
			ps.setInt(1, start);
			ps.setInt(2, end);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				FoodVO vo=new FoodVO();
				vo.setFno(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setPoster(rs.getString(3).replace("https", "http"));
				
				list.add(vo);
			}
			rs.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			dbconn.disConnection(conn, ps);
		}
		return list;
	}
	//총 페이지 구하기
	public int foodTotalPage() {
	int total=0;
	try{
		conn=dbconn.getConnection();
		String sql="SELECT CEIL(COUNT(*)/"+ROWSIZE+") FROM food_house ";
		
		ps=conn.prepareStatement(sql);
		// selectOne() => 단일값을 받아서 while 문을 돌릴 필요가 없을때
		ResultSet rs=ps.executeQuery();
		rs.next();
		total=rs.getInt(1);
		rs.close();
	}catch(Exception ex){
		ex.printStackTrace();
	}finally {
		dbconn.disConnection(conn, ps);
	}
	return total;

	}
	//상세보기
/*
   private int fno;
   private String name,type,phone,address,theme,poster,content;
   private double score;
   		try {
			conn=dbconn.getConnection();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			dbconn.disConnection(conn, ps);
		}
 */
	public FoodVO foodDetailData(int fno) {
		FoodVO vo=new FoodVO();
		try {
			conn=dbconn.getConnection();
			String sql="UPDATE food_house SET "
			  		  +"hit=hit+1 "
			  		  +"WHERE fno="+fno;
			ps=conn.prepareStatement(sql);
			ps.executeUpdate();
			
			sql="SELECT fno,name,type,phone,address,theme,poster,content,score "
			   +"FROM food_house "
			   +"WHERE fno="+fno;
			ps=conn.prepareStatement(sql); //오라클로 전송
			ResultSet rs=ps.executeQuery(); // 실행 후 결과값을 메모리에 저장
			rs.next(); //데이터 출력한 위치에 커서 두기
			vo.setFno(rs.getInt(1));
			vo.setName(rs.getString(2));
			vo.setType(rs.getString(3));
			vo.setPhone(rs.getString(4));
			vo.setAddress(rs.getString(5));
			vo.setTheme(rs.getString(6));
			vo.setPoster(rs.getString(7).replace("https", "http"));
			vo.setContent(rs.getString(8));
			vo.setScore(rs.getDouble(9));
			
			rs.close();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			dbconn.disConnection(conn, ps);
		}
		return vo;
	}
	//seoul => 명소 => 6개 출력
	public List<FoodVO> foodLocationData(String addr){
		List<FoodVO> list=new ArrayList<FoodVO>();
   		try {
			conn=dbconn.getConnection();
			String sql="SELECT fno,name,poster,rownum "
					  +"FROM food_house "
					  +"WHERE rownum<=6 AND "
					  +"address LIKE '%'||?||'%'";
			ps=conn.prepareStatement(sql);
			ps.setString(1, addr);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				FoodVO vo=new FoodVO();
				vo.setFno(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setPoster(rs.getString(3));
				vo.setAddress(rs.getString(4));
				
				list.add(vo);
			}
			rs.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			dbconn.disConnection(conn, ps);
		}
		return list;
	}
	public List<FoodVO> foodFindData(int page,String addr){
		List<FoodVO> list=new ArrayList<FoodVO>();
		try {
			conn=dbconn.getConnection();
			String sql="SELECT fno,name,poster,address,num "
					  +"FROM (SELECT fno,name,poster,address,rownum as num "
					  +"FROM (SELECT fno,name,poster,address "
					  +"FROM food_house "
					  +"WHERE address LIKE '%'||?||'%')) "
					  +"WHERE num BETWEEN ? AND ? ";
			ps=conn.prepareStatement(sql);
			int start=(ROWSIZE*page)-(ROWSIZE-1);
			int end=ROWSIZE*page;
			
			ps.setString(1, addr);
			ps.setInt(2, start);
			ps.setInt(3, end);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				FoodVO vo=new FoodVO();
				vo.setFno(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setPoster(rs.getString(3).replace("https", "http"));
				vo.setAddress(rs.getString(4));
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			dbconn.disConnection(conn, ps);
		}
		return list;
	}
	
	public int foodFindTotalPage(String addr) {
	int total=0;
	try{
		conn=dbconn.getConnection();
		String sql="SELECT CEIL(COUNT(*)/"+ROWSIZE+") FROM food_house "
				  +"WHERE address LIKE '%'||?||'%'";
		
		ps=conn.prepareStatement(sql);
		ps.setString(1, addr);
		ResultSet rs=ps.executeQuery();
		rs.next();
		total=rs.getInt(1);
		rs.close();
	}catch(Exception ex){
		ex.printStackTrace();
	}finally {
		dbconn.disConnection(conn, ps);
	}
	return total;

	}
	public int foodFindCount(String addr) {
	int total=0;
	try{
		conn=dbconn.getConnection();
		String sql="SELECT COUNT(*) FROM food_house "
				  +"WHERE address LIKE '%'||?||'%'";
		
		ps=conn.prepareStatement(sql);
		ps.setString(1, addr);
		ResultSet rs=ps.executeQuery();
		rs.next();
		total=rs.getInt(1);
		rs.close();
	}catch(Exception ex){
		ex.printStackTrace();
	}finally {
		dbconn.disConnection(conn, ps);
	}
	return total;

	}
	public List<FoodVO> foodFooterData(){
		List<FoodVO> list=new ArrayList<FoodVO>();
		try {
			conn=dbconn.getConnection();
			String sql="SELECT fno,name,hit,rownum "
					  +"FROM (SELECT fno,name,hit "
					  +"FROM food_house ORDER BY hit DESC) "
					  +"WHERE rownum<=7 ";
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				FoodVO vo=new FoodVO();
				vo.setFno(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setHit(rs.getInt(3));
				list.add(vo);
			}
			rs.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			dbconn.disConnection(conn, ps);
		}
		return list;
	}

	
	
	

}







