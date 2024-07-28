package com.sist.dao;
import java.util.*;
import java.sql.*;
import com.sist.vo.GoodsVO;
import dao.Dbcpconnection;
public class GoodsDAO {
	private Connection conn;
	private PreparedStatement ps;
	private static GoodsDAO dao;
	private Dbcpconnection dbconn=new Dbcpconnection();
	
	public static GoodsDAO newInstance() {
		if(dao==null)
			dao=new GoodsDAO();
		return dao;
	}
	
	public List<GoodsVO> goodsTop12(){
		List<GoodsVO> list=new ArrayList<GoodsVO>();
		try {
			conn=dbconn.getConnection();
			String sql="SELECT no,goods_name,goods_poster,rownum "
					  +"FROM (SELECT no,goods_name,goods_poster "
					  +"FROM goods_all ORDER BY hit DESC) "
					  +"WHERE rownum<=12" ;
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				GoodsVO vo=new GoodsVO();
				vo.setNo(rs.getInt(1));
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
	public List<GoodsVO> goodsListData(){
		List<GoodsVO> list= new ArrayList<GoodsVO>();
		
		return list;
	}
	
	
	
	

}










