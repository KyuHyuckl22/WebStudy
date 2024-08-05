package com.sist.dao;
import java.util.*;

import com.sist.vo.AlbumVO;

import java.sql.*;
public class AlbumDAO {
	   private Connection conn;
	   private PreparedStatement ps;
	   private static AlbumDAO dao;
	   private final String URL="jdbc:oracle:thin:@192.168.0.124:1521:XE";
	  
	   public AlbumDAO()
	   {
		   try
		   {
			   Class.forName("oracle.jdbc.driver.OracleDriver");
		   }catch(Exception ex) {}
	   }
	  
	   // 연결
	   public void getConnection()
	   {
		   try
		   {
			   conn=DriverManager.getConnection(URL,"hr3","happy");
		   }catch(Exception ex) {}
	   }
	   // 해제
	   public void disConnection()
	   {
		   try
		   {
			   if(ps!=null) ps.close();
			   if(conn!=null) conn.close();
		   }catch(Exception ex) {}
	   }
	   // 싱글턴
	   public static AlbumDAO newInstance()
	   {
		   if(dao==null)
			   dao=new AlbumDAO();
		   return dao;
	   }
	   /*

	   앨범스토어       album_store

	   ANO			NUMBER						앨범번호
	   APHOTO		VARCHAR2(2000 BYTE)			앨범사진
	   ANAME			VARCHAR2(2000 BYTE)			앨범이름
	   ARTIST			VARCHAR2(2000 BYTE)			아티스트
	   ARDATE			DATE							발매일
	   ARATING		NUMBER						별점
	   APRICE			VARCHAR2(2000 BYTE)			앨범가격
	   ADIS			VARCHAR2(2000 BYTE)			할인율
	   ADISPRICE		VARCHAR2(2000 BYTE)			할인가격
	   ADETAIL		VARCHAR2(4000 BYTE)			앨범속성
	   AIMG			VARCHAR2(4000 BYTE)			앨범이미지

	    */
	   public void bookInsert(AlbumVO vo)
	   {
		   try
		   {
			   getConnection();
			   String sql="INSERT INTO book "
					     +"VALUES(book_bno_seq.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			   ps=conn.prepareStatement(sql);
			   ps.setString(1, vo.getBtag());
			   ps.setString(2, vo.getBgenre());
			   ps.setString(3, vo.getCover());
			   ps.setString(4, vo.getBtitle());
			   ps.setString(5, vo.getWriter());
			   ps.setString(6, vo.getPrice());
			   ps.setString(7, vo.getSale_price());
			   ps.setString(8, vo.getDis_rate());
			   ps.setString(9, vo.getBdate());
			   ps.setString(10, vo.getPublisher());
			   ps.setString(11, vo.getIntro());
			   ps.setString(12, vo.getIntro_img());
			   ps.setString(13, vo.getPages());
			   ps.setLong(14, Long.parseLong(vo.getIsbn13()));
			   ps.setInt(15, Integer.parseInt(vo.getIsbn10()));
			  
			   ps.executeUpdate();
		   }catch(Exception ex)
		   {
			   ex.printStackTrace();
		   }
		   finally
		   {
			   disConnection();
		   }
	   }
	}
