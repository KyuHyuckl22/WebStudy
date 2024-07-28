package service;
import java.util.*;
import java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy;
import java.sql.*;
import javax.sql.*;
import dao.*;
public class EmpDAO {
	private Connection conn;
	private PreparedStatement ps;
	private static EmpDAO dao;
	private Dbcpconnection dbconn = new Dbcpconnection();
	public static EmpDAO newInstance() {
		if(dao==null)
			dao=new EmpDAO();
		return dao;
	}
	
	public List<EmpVO> empListData(){
		List<EmpVO> list=new ArrayList<EmpVO>();
		try {
			conn=dbconn.getConnection();
			String sql="SELECT empno, ename, job, hiredate, sal "
					  +"FROM emp";
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				EmpVO vo=new EmpVO();
				vo.setEmpno(rs.getInt(1));
				vo.setEname(rs.getString(2));
				vo.setJob(rs.getString(3));
				vo.setHiredate(rs.getDate(4));
				vo.setSal(rs.getInt(5));
				list.add(vo);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			dbconn.disConnection(conn, ps);
		}
		return list;
	}
	
	
}
