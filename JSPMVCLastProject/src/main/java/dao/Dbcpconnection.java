package dao;
import java.util.*;
import java.sql.*;
import javax.sql.*;
import javax.naming.*;
/*
 *  DBCP => 관리를 톰캣 에서 한다. => 일반 프로그램에서는 사용 (x)  웹에서만 사용이 가능
 */
public class Dbcpconnection {
	
	public Connection getConnection() {
		Connection conn=null;
		try {
			Context init=new InitialContext();
			Context c=(Context)init.lookup("java://comp/env");
			DataSource ds=(DataSource)c.lookup("jdbc/oracle");
			conn=ds.getConnection();
		}catch(Exception ex) {
			ex.printStackTrace();
		}			
		return conn;
	}
	
	public void disConnection(Connection conn, PreparedStatement ps) {
		try {
			if(ps!=null)ps.close();
			if(conn!=null)conn.close();
		}catch(Exception ex) {}
	}
	
}
