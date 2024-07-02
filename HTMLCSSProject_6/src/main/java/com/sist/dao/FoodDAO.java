package com.sist.dao;

import java.sql.*;
import java.util.*;
import java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy;

import com.sist.database.*;
public class FoodDAO {
	private Connection conn;
	private PreparedStatement ps;
	private static FoodDAO dao;
	private final String URL="jdbc:oracl:@localhost:1521:XE";
	private DataBaseConnection dbConn=new DataBaseConnection();
	// 싱글턴
	public static FoodDAO newInstance() {
		if(dao==null)
			dao=new FoodDAO();
		return dao;
	}
	
	public List<FoodVO> foodListData(){
		List<FoodVO> list=new ArrayList<FoodVO>();
		try {
			conn=dbConn.getConnection();
			String sql="SELECT fno,name,poster,type,rownum "
					 + "FROM (SELECT fno,name,poster,type "
					 + "FROM food_house ORDER BY fno ASC) "
					 + "WHERE rownum<=50 ";
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				FoodVO vo=new FoodVO();
				vo.setFno(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setPoster(rs.getString(3));
				vo.setType(rs.getString(4));
				
				list.add(vo);
			}
			rs.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			dbConn.disConnection(conn, ps);
		}
		return list;
	}
	
	
}
