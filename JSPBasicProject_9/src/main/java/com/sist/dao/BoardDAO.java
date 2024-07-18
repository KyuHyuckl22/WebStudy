package com.sist.dao;
import java.util.*;
import java.sql.*;
import javax.sql.*;
import javax.naming.*;
public class BoardDAO {
	private Connection conn;
	private PreparedStatement ps;
	private static BoardDAO dao;
	
	public static BoardDAO newInstance() {
		if(dao==null)
			dao = new BoardDAO();
		return dao;
	}
	public void getConnection() {
		
	}
	public void disConnection() {
		
	}
//	기능
//	
//	
//	
//	
//	
//	
//	
//	
//	
	
	
}
