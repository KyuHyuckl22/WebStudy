package com.sist.dao;
import java.util.*;
import java.sql.*;
import com.sist.database.DataBaseConnection;
/*
 * 		(이론보단 라이브러리 사용해서 조립에 더 주력)
 * 		(웹은 프로그래머지 개발자가 아니다(?)) 
 * 	1. 오라클 연결 => TCP
 * 		Connection : Socket  (connection 에는 socket 이 들어가 있다)
 * 					======== IP / PORT 
 * 	2. SQL 문장 전송 / 수신
 * 	   PrepardStatement : BufferedReader / OutputStream
 * 							|				   └ executeQuery, executeUpdate
 * 						  ResultSet => 브라우저 전송 : List/VO
 *	======================================================
 *				요청->		 요청값 받기 (request)
 *		브라우저 <=============> 서버 (DAO,JSP)
 * 					   <-응답 (HTML) 
 * 				response : OutputStream
 *		네트워크 : 서버 / 클라이언트
 *				|
 *			   오라클 / 웹 (톰켓)
 *		순서 => SQL 문장 주력 
 *					
 * 	
 *  1. JSP
 *     ======  1) 오라클로부터 데이터 읽기
 *                <%
 *                %>
 *             2) 데이터를 HTML 출력
 *                
 *             
 *             
 *             
 *             
 */
public class FoodDAO {
	   private Connection conn; // 인터페이스는 뉴를 사용 못 함 
	   private PreparedStatement ps;
	   private DataBaseConnection dbConn = new DataBaseConnection(); // 얘는 일반클래스 ~.~
	   private static FoodDAO dao; // 싱글턴
	   private String[] mode = {"","한식","중식","양식","일식"};

	public static FoodDAO newInstance() {
		if(dao==null)
			dao=new FoodDAO();
		return dao;
	}
	
	public List<FoodVO> foodFindData(String addr, int page){
		List<FoodVO> list=new ArrayList<FoodVO>();
		try {
			conn=dbConn.getConnection();
			String sql="SELECT fno, name, poster, num "
					  +"FROM (SELECT fno, name, poster, rownum as num "
					  +"FROM (SELECT fno, name, poster "
					  +"FROM food_house WHERE address LIKE '%'||?||'%')) "
					  +"WHERE num BETWEEN ? AND ? ";
			ps=conn.prepareStatement(sql);
			//?에 값 채우기
			int rowSize=12;
			int start=(rowSize*page)-(rowSize-1);
			int end=rowSize*page;
//			? 에 값을 3개를 넣어주지 않으면 IN OUT 오류가 뜰것
			ps.setString(1, addr);
			ps.setInt(2, start);
			ps.setInt(3, end);
//			결과값 받기
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				FoodVO vo = new FoodVO();
				vo.setFno(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setPoster(rs.getString(3).replace("https", "http"));
				list.add(vo);
				
			}
			
			
		}catch(Exception ex) {
			System.out.println("==== foodFindData() 오류발생 ====");
			ex.printStackTrace();
		}finally {
			dbConn.disConnection(conn, ps);
		}
		return list;
	}
	
	public int foodFindTotalPage(String addr) {
		int total=0;
		try {
			conn=dbConn.getConnection();
			String sql="SELECT CEIL (COUNT(*)/12.0) "
					  +"FROM food_house "
					  +"WHERE address LIKE '%'||?||'%' ";
			ps=conn.prepareStatement(sql);
			ps.setString(1, addr);
			ResultSet rs=ps.executeQuery();
			rs.next();
			
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			dbConn.disConnection(conn, ps);
		}
		return total;
	}
	// 종류별 분리
/*
 * INSERT : 게시판 글쓰기, 댓글, 회원가입, 장바구니
 * UPDATE : 게시판 수정, 댓글 수정, 회원정보 수정, 장바구니 수정, 예약수정
 * DELETE : 게시판 삭제, 댓글 삭제, 회원 탈퇴, 장바구니 취소,예약 취소
 * 나머지 : SELECT
 */
	public List<FoodVO> foodListData(int type,int page){
		List<FoodVO> list=new ArrayList<FoodVO>();
		String[] mode= {"","한식","중식","양식","일식"};
		try {
			conn=dbConn.getConnection();
			String sql="SELECT fno, name, poster, num "
					  +"FROM (SELECT fno, name, poster, rownum as num "
					  +"FROM (SELECT fno, name, poster "
					  +"FROM food_house WHERE REGEXP_LIKE(type,?))) "
					  +"WHERE num BETWEEN ? AND ? ";
			// rownum 은 Top-n 처음부터.  중간은 자르지 못한다 => 인라잉ㄴ뷰
			ps=conn.prepareStatement(sql);
			int rowSize=12;
			int start=(rowSize*page)-(rowSize-1);
			int end=rowSize*page;
			
			ps.setString(1, mode[type]);
			ps.setInt(2, start);
			ps.setInt(3, end);
			//
				
	         ResultSet rs=ps.executeQuery();
	         while(rs.next()) {
	            FoodVO vo = new FoodVO();
	            vo.setFno(rs.getInt(1));
	            vo.setName(rs.getString(2));
	            vo.setPoster(rs.getString(3));
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

	 public int foodListTotalPage(int type) {
	      int total=0;
	      try {
	         conn=dbConn.getConnection();
	         String sql="SELECT CEIL(COUNT(*)/12.0)"
	               +"FROM food_house "
	               +"WHERE type LIKE '%'||?||'%'";
	         ps=conn.prepareStatement(sql);
	         ps.setString(1, mode[type]);
	         ResultSet rs=ps.executeQuery();
	         rs.next();
	         total=rs.getInt(1);
	         rs.close();
	                  
	      }catch(Exception ex) {
	         ex.printStackTrace();
	      }
	      finally {
	         dbConn.disConnection(conn, ps);
	      }
	      return total;
	      
	   }
	}






