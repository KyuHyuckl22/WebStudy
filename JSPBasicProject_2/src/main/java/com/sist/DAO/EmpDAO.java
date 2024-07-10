package com.sist.DAO;
import java.util.*;

import javax.naming.spi.DirStateFactory.Result;

import java.sql.*;
import com.sist.database.*;
public class EmpDAO {
//	AWS 는 프로젝트 실행할 때 어떤 위치든 상관없이 실행이 가능하다
	private Connection conn;
	private PreparedStatement ps;
	private static EmpDAO dao;
	private DataBaseConnection dbconn = new DataBaseConnection();
	
//	싱글턴
	public static EmpDAO newInstance() {
		if(dao==null)
			dao=new EmpDAO();
		return dao;
	}
//	기능 => 목록
	public List<EmpVO> empListData(){
		List<EmpVO> list = new ArrayList<EmpVO>();
		try {
			conn=dbconn.getConnection();
			String sql="SELECT empno, ename, job, hiredate, comm "
					 + "FROM emp "
					 + "ORDER BY empno ASC ";
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				EmpVO vo = new EmpVO();
				vo.setEmpno(rs.getInt(1));
				vo.setEname(rs.getString(2));
				vo.setJob(rs.getString(3));
				vo.setHiredate(rs.getDate(4));
				vo.setComm(rs.getInt(5));
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









