package com.sist.dao;
/*
 * 	table => VO , DAO
 * 	====== table 여러개가 혼합되면 : DAO 가 => Service 가 된다
 * 										======== board / reply 두개 통합시 
 * 										======== food / jjim / like
 */
import java.util.*;
import java.sql.*;
import javax.sql.*;
import javax.naming.*;
import javax.security.auth.Subject;
public class DiaryService {
	private Connection conn;
	private PreparedStatement ps;
	private static DiaryService dao;
	
	public static DiaryService newInstance() {
		if(dao==null)
			dao=new DiaryService();
		return dao;
	}
	// 미리 톰캣에 의해 생성된 Connection 주소를 얻어온다
	
	public void getConnection()
	{
		try {
			Context init=new InitialContext();
			Context c=(Context)init.lookup("java://comp/env");
			DataSource da=(DataSource)c.lookup("jdbc/oracle");
			conn=da.getConnection();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	// 다시 Connection 관리영역 (pool)
	public void disConnection() {
		try {
			if(ps!=null)ps.close();
			if(conn!=null)conn.close();
		}catch(Exception ex){}
	}
//	1. 로그인 => 세션 사용 => 사용자 정보 저장
	public MemberVO isLogin(String id,String pwd) {
		MemberVO vo=new MemberVO();
		try {
			getConnection();
			// 1.아이디 존재여부 확인
			String sql="SELECT COUNT(*) FROM member "
					  +"WHERE id=? ";
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs=ps.executeQuery();
			rs.next();
			int count=rs.getInt(1);
			rs.close();
			
			if (count==0) { //id가 없는 상태
				vo.setMsg("NOID");
			}else { //id가 있는 상태
				sql="SELECT pwd,name,sex FROM member "
				   +"WHERE id=? ";
				ps=conn.prepareStatement(sql);
				ps.setString(1, id);
				
				rs=ps.executeQuery();
				rs.next();
				String db_pwd=rs.getString(1);
				String name=rs.getString(2);
				String sex=rs.getString(3);
				rs.close();
				
				if(db_pwd.equals(pwd)) {
					vo.setId(id);
					vo.setName(name);
					vo.setSex(sex);
					vo.setMsg("OK");
				}else { //비밀번호가 틀린 상태
					vo.setMsg("NOPWD");
				}
			}
			// 2. 비밀번호 확인
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			disConnection();
		}
		return vo;
	}
/*
 * 	로그인 을 한다면 매개변수 => id,pwd => 사용자가 입력하거니 클릭
 * 						======= 사용자 전송
 * 				리턴형 => 결과값
 * 				==== 경우의 수 => 경우의 수 1 => list/vo/int
 * 							   경우의 수 2 => boolean
 * 							   경우의 수 여러개 => String
 */
//	2. 일정관리 : 아이디 별로
//	2-1 일정 등록
	public void diaryInsert(DiaryVO vo) {
		try {
			getConnection();
			String sql="INSERT INTO diary VALUES( "
					  +"diary_no_seq.nextval,?,?,?,?,?,?,SYSDATE) ";
			ps=conn.prepareStatement(sql);
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getSubject());
			ps.setString(3, vo.getMsg());
			ps.setInt(4, vo.getYear());
			ps.setInt(5, vo.getMonth());
			ps.setInt(6, vo.getDay());
			ps.executeUpdate();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			disConnection();
		}
	}
//	2-2 일정 출력
	public List<DiaryVO> diaryListData(DiaryVO vo){
		List<DiaryVO> list=new ArrayList<DiaryVO>();
		try {
			getConnection();
			String sql="SELECT no,subject,TO_CHAR(regdate,'YYYY-MM-DD'),msg,year,month,day "
					  +"FROM diary "
					  +"WHERE id=? AND year=? AND month=? AND day=? "
					  +"ORDER BY no DESC ";
			// INDEX => 검색이 많은 경우, 데이터가 많은 경우
			// ===> 수정, 삭제, 추가가 많은 경우에는 INDEX를 계속  rebuild 하기 때문에 속도가 느리다
			ps=conn.prepareStatement(sql);
			ps.setString(1, vo.getId());
			ps.setInt(2, vo.getYear());
			ps.setInt(3, vo.getMonth());
			ps.setInt(4, vo.getDay());
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				DiaryVO dvo=new DiaryVO();
				dvo.setNo(rs.getInt(1));
				dvo.setSubject(rs.getString(2));
				dvo.setDbday(rs.getString(3));
				dvo.setMsg(rs.getString(4));
				dvo.setYear(rs.getInt(5));
				dvo.setMonth(rs.getInt(6));
				dvo.setDay(rs.getInt(7));
				list.add(dvo);
			}
			rs.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			disConnection(); // 반환 (재사용) => Connection 을 관리하기 편리, 일정 갯수 유지
		}
		return list;
				
	}
//	2-3 달력에 일정 표시
	public int diaryCheck(String id,int year, int month, int day) {
		int bCheck=0;
		try {
			getConnection();
			String sql="SELECT COUNT(*) FROM diary "
					  +"WHERE id=? AND year=? AND month=? AND day=? ";
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setInt(2, year);
			ps.setInt(3, month);
			ps.setInt(4, day);
					   ResultSet rs=ps.executeQuery();		   rs.next();		   bCheck=rs.getInt(1);		   rs.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally { 
			disConnection();
		}
		return bCheck;
		
	}
//	2-4 일정 수정
	public DiaryVO diaryUpdateData(int no) {
		DiaryVO vo=new DiaryVO();
		try {
			getConnection();
			String sql="SELECT no,subject,msg,year,month,day "
					  +"FROM diary "
					  +"WHERE no= "+no;
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			rs.next();
			vo.setNo(rs.getInt(1));
			vo.setSubject(rs.getString(2));
			vo.setMsg(rs.getString(3));
			vo.setYear(rs.getInt(4));
			vo.setMonth(rs.getInt(5));
			vo.setDay(rs.getInt(6));
			rs.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally { 
			disConnection();
		}
		return vo;
	}
	public void diaryUpdate (DiaryVO vo) {
		try {
			getConnection();
			String sql="UPDATE diary SET "
					  +"subject=?,msg=?, "
					  +"year=?,month=?,day=?,regdate=SYSDATE "
					  +"WHERE no=? ";
			ps=conn.prepareStatement(sql);
			// ?에 값을 채운다
			ps.setString(1, vo.getSubject());
			ps.setString(2, vo.getMsg());
			ps.setInt(3, vo.getYear());
			ps.setInt(4, vo.getMonth());
			ps.setInt(5, vo.getDay());
			ps.setInt(6, vo.getNo());
			ps.executeUpdate();
//			ResultSet rs=ps.executeQuery();
//			rs.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally { 
			disConnection();
		}
		
	}
//	2-5 일정 취소
	public void diaryDelete(int no) {
		try {
			getConnection();
			String sql="DELETE FROM diary WHERE no="+no;
			ps=conn.prepareStatement(sql);
			ps.executeUpdate();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally { 
			disConnection();
		}
	}
//	3. 장바구니 : 세션 => 제공하는 메소드 정리
//	3-1 상품 출력
//	3-2 장바구니 등록 => 세션처리
//	3-3 장바구니 상품 취소
//	3-4 구매 => 데이터 베이스에 저장
	
	
	
	
	
	
	
	
}
