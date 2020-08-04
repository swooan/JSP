package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GuestBookDao {
	
	private static GuestBookDao instance;
	private GuestBookDao() {};
	
	public static GuestBookDao getInstance() {
		if(instance == null) {
			instance = new GuestBookDao();
		}
		return instance;
	}
	
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	String LIST = "SELECT * FROM GUESTBOOK ORDER BY NO ASC";
	String INSERT = "INSERT INTO GUESTBOOK VALUES(seq_guestbook_no.NEXTVAL, ?,?,?,SYSDATE)";
	String DELETE = "DELETE FROM GUESTBOOK WHERE PASSWORD = ?";
	
	public ArrayList<GuestBookVo> List() {
		ArrayList<GuestBookVo> list = new ArrayList<GuestBookVo>();
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(LIST);
			
			while(rs.next()) {
				int no = rs.getInt(1);
				String name = rs.getString(2);
				String password = rs.getString(3);
				String content = rs.getString(4);
				Date reg_date = rs.getDate(5);
				
				GuestBookVo vo = new GuestBookVo(no, name, password, content, reg_date);
				
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void Insert(GuestBookVo vo) {
		
		try {
			pstmt = conn.prepareStatement(INSERT);
			
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getContent());
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt <= 0) {
				System.out.println("등록 실패");
				conn.rollback();
			}
			else {
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void Delete(GuestBookVo vo) {
		try {
			pstmt = conn.prepareStatement(DELETE);
			
			pstmt.setString(1, vo.getPassword());
			
			int cnt = pstmt.executeUpdate();
			
			if(cnt <= 0) {
				System.out.println("삭제 실패");
				conn.rollback();
			}
			else {
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
