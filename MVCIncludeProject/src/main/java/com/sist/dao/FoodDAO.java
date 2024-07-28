package com.sist.dao;
import java.util.*;
import java.sql.*;
import dao.*;
public class FoodDAO {
	private Connection conn;
	private PreparedStatement ps;
	private static FoodDAO dao;
	private Dbcpconnection dbconn=new Dbcpconnection();
	
	public static FoodDAO newInstance() {
		if(dao==null)
			dao=new FoodDAO();
		return dao;
	}
	
	public List<FoodVO> foodListData(int page){
		List<FoodVO> list=new ArrayList<FoodVO>();
		try {
			conn=dbconn.getConnection();
			String sql="SELECT fno,hit,name,type,poster,num "
					  +"FROM (SELECT fno,hit,name,type,poster,rownum as num "
					  +"FROM (SELECT fno,hit,name,type,poster "
					  +"FROM food_house ORDER BY fno ASC)) "
					  +"WHERE num BETWEEN ? AND ? ";
			ps=conn.prepareStatement(sql);
			int rowSize=12;
			int start=(rowSize*page)-(rowSize-1);
			int end=rowSize*page;
			
			ps.setInt(1, start);
			ps.setInt(2, end);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				FoodVO vo=new FoodVO();
				vo.setFno(rs.getInt(1));
				vo.setHit(rs.getInt(2));
				vo.setName(rs.getString(3));
				vo.setType(rs.getString(4));
				vo.setPoster(rs.getString(5));
				
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
	public int foodTotalPage() {
		int total=0;
		try {
			conn=dbconn.getConnection();
			String sql="SELECT CEIL (COUNT(*)/12.0) FROM food_house ";
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			rs.next();
			total=rs.getInt(1);
			rs.close();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			dbconn.disConnection(conn, ps);
			
		}
		
		return total;
	}
	public FoodVO foodDetailData(int fno) {
		FoodVO vo=new FoodVO();
		try {
			conn=dbconn.getConnection();
			String sql="SELECT fno,hit,name,type,poster "
					  +"FROM food_house "
					  +"WHERE fno="+fno;
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			rs.next();
			vo.setFno(rs.getInt(1));
			vo.setHit(rs.getInt(2));
			vo.setName(rs.getString(3));
			vo.setType(rs.getString(4));
			vo.setPoster(rs.getString(5));
			rs.close();
					  
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			dbconn.disConnection(conn, ps);
		}
		return vo; 
	}
	
	
	
}











