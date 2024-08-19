package com.sist.dao;

import com.sist.vo.AlbumVO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class AlbumDAO {
    private Connection conn;
    private PreparedStatement ps;
    private static AlbumDAO dao;
    private final String URL = "jdbc:oracle:thin:@211.238.142.124:1521:XE";

    // 드라이버 등록
    public AlbumDAO() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    // 연결
    public void getConnection() {
        try {
            conn = DriverManager.getConnection(URL, "hr3", "happy");
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    // 해제
    public void disConnection() {
        try {
            if(ps != null) ps.close();
            if(conn != null) conn.close();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    // 싱글턴
    public static AlbumDAO newInstance() {
        if(dao == null) dao = new AlbumDAO();
        return dao;
    }

    // 기능
    public void albumInsert(AlbumVO vo) {
        try {
            getConnection();
            String sql = "INSERT INTO Album_store(ano, ardate, aphoto, aname, aartist, aprice, adisprice, adetail, aimg) "
                    + "VALUES(al_ano_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(sql);

            ps.setString(1, vo.getArdate());
            ps.setString(2, vo.getAphoto());
            ps.setString(3, vo.getAname());
            ps.setString(4, vo.getAartist());
            ps.setString(5, vo.getAprice());
            ps.setString(6, vo.getAdisprice());
            ps.setString(7, vo.getAdetail());
            ps.setString(8, vo.getAimg());

            ps.executeUpdate();
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            disConnection();
        }
    }
}
