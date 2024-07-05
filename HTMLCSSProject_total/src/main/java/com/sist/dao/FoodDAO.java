package com.sist.dao;
/*
 *  클래스의 종류 (역할) => 클래스는 한개의 기능을 수행하는 역할
 *                         ================== 컴포넌트
 *  VO -> 데이터를 모아서 브라우저||모바일에 한번에 전송
 *  DAO -> 데이터베이스 연동
 *  Manager -> 관리 -> 데이터 수집 / Open API 
 *  Service -> 사용자 요청처리
 *  Model (Controller) -> 사용자 요청을 받아서 결과를 전송
 *  =============================================== MVC 구조에서 자주나옴
 *  												
 *  	
 */
import java.util.*;

import javax.naming.spi.DirStateFactory.Result;

import com.sist.database.DataBaseConnection;

import java.sql.*;
/*
 *  			   JSP 프로젝트        Spring 프로젝트       Spring-Boot => 개인 프로젝트
 *  JDBC =========> DBCP ===========> ORM ============> DataSet
 *    |				 |                 |                   |
 *   기본			   연결 속도            라이브러리            SQL 문장을 자동으로 만들어줌
 *                Connection관리    (데이터베이스만 연결)          JPA
 *                					MyBatis
 *  요즘 자격요건 : Spring 가능자 , JQuerty | Vue | React , MySQL , Spring-Boot , AWS 
 *            =============  
 *             └ Java+JSP+ORACLE
 *  	우대사항 : 리눅스, 정보처리기사 , DevOps
 *                             ======= 개발 + 운영  => Docker / 쿠바네티스 / 젠킨스
 *                             => 실시간 배포 (CI / CD)
 *  프로그램이란 == 데이터 관리
 *  		   ========
 *             1. 변수   => 배열 / 클래스 / 파일 / RDBMS
 *             2. 연산자 
 *             3. 제어문
 *             
 *                        
 *             
 *             
 */
public class FoodDAO {
	private Connection conn; // 오라클 연결 담당
	private PreparedStatement ps; // SQL 문장 전송 => 실행 결과를 가지고 온다
//	        미리 sql 문장을 전송하고, 필요한 데이터는 나중에 전송한다
//	                           ====================  미리 전송하고 ? 에 값을 채워준다
	private static FoodDAO dao; //
//	싱글턴 => 메모리 공간을 1개만 사용하겠다.
//	메모리 공간을 1개만 쓰게 되면 => 메모리 누수현상 방지, Connection 을 남발하지 않는다(서버의 부하를 줄일수 있다)
	private DataBaseConnection dbconn = new DataBaseConnection();
/*	연결 / 해제 기능
 *  모든 데이터베이스에서 공통으로 사용되는 기능 => 라이브러리화 시킨것
 */
//	싱글턴 제작
	public static FoodDAO newInstance() {
		if(dao==null)
			dao=new FoodDAO();
		return dao;
	}
//	기능 수행
	public List<FoodVO> foodListData(){
		List<FoodVO> list = new ArrayList<FoodVO>();
/*
 *      예외처리
 *      =====
 *      java.sql, java.id, java.net => 컴파일 예외 (반드시 예외처리를 한다)
 */
		try {
//			연결
			conn=dbconn.getConnection();
//			SQL 문장 제작
			String sql = "SELECT fno, name, poster, rownum "
					   + "FROM food_house "
					   + "WHERE rownum<=20 ";
//			SQL 문장 전송
			ps=conn.prepareStatement(sql);
//			필요한 데이터 있는지 확인 -> ? 가 있는지
//			오라클에서 실행된 결과값을 받는다
			ResultSet rs=ps.executeQuery();
//			List에 첨부후 전송 준비
			while(rs.next()) {
				FoodVO vo = new FoodVO();
				vo.setFno(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setPoster(rs.getString(3).replace("https", "http"));
				
				list.add(vo);
			}rs.close();
			
		}catch(Exception ex) {
			System.out.println("==== foodListData 오류발생 ====");
			ex.printStackTrace();
		}finally {
			dbconn.disConnection(conn, ps);
		}
		return list;
	}
	
}












