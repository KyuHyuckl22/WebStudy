package com.sist.dao;
import java.util.*;

import javax.tools.DocumentationTool.Location;

import com.sist.vo.LocationVO;

import java.sql.*;
import dao.Dbcpconnection;
public class LocationDAO {
	private Connection conn;
	private PreparedStatement ps;
	private static LocationDAO dao;
	private Dbcpconnection dbconn=new Dbcpconnection();
	private final int ROWSIZE=20;
	public static LocationDAO newInstance() {
		if(dao==null)
			dao=new LocationDAO();
		return dao;
	}
	
	public List<LocationVO> seoulTop12(){
		List<LocationVO> list=new ArrayList<LocationVO>();
		try {
			conn=dbconn.getConnection();
			String sql="SELECT no,title,poster,rownum "
					  +"FROM (SELECT no,title,poster "
					  +"FROM seoul_location) "
					  +"WHERE rownum<=12" ;
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				LocationVO vo=new LocationVO();
				vo.setNo(rs.getInt(1));
				vo.setTitle(rs.getString(2));
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
	public List<LocationVO> seoulListData(int page){
		List<LocationVO> list=new ArrayList<LocationVO>();
		try {
			conn=dbconn.getConnection();
			String sql="SELECT no,title,poster,num "
					  +"FROM (SELECT no,title,poster,rownum as num "
					  +"FROM (SELECT no,title,poster "
					  +"FROM seoul_location ORDER BY no ASC)) "
					  +"WHERE num BETWEEN ? AND ? ";
			ps=conn.prepareStatement(sql);
			
			int start=(ROWSIZE*page)-(ROWSIZE-1);
			int end=ROWSIZE*page;
			
			ps.setInt(1, start);
			ps.setInt(2, end);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				LocationVO vo=new LocationVO();
				vo.setNo(rs.getInt(1));
				vo.setTitle(rs.getString(2));
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
	public int seoulTotalPage() {
		int total=0;
		try {
			conn=dbconn.getConnection();
			String sql="SELECT CEIL(COUNT(*)/"+ROWSIZE+") FROM seoul_location ";
			ps=conn.prepareStatement(sql);
			
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
	
	

}












