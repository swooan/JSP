package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MailDao {
	
	private static MailDao instance;
	private MailDao() {};
	
	public static MailDao getInstance() {
		if(instance == null) {
			instance = new MailDao();
		}
		return instance;
	}
	
	Connection conn;
	Statement stmt;
	ResultSet rs;
	PreparedStatement pstmt;
	int cnt = 0;
	
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	String LIST = "SELECT * FROM EMAILLIST ORDER BY NO ASC";
	String INSERT = "INSERT INTO EMAILLIST VALUES(seq_emaillist_no.nextval,?,?,?)";
	
	public ArrayList<MailVo> List() {
		
		ArrayList<MailVo> list = new ArrayList<>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(LIST);
			
			while(rs.next()) {
				int no = rs.getInt(1);
				String last_name = rs.getString(2);
				String first_name = rs.getString(3);
				String email = rs.getString(4);
				
				MailVo vo = new MailVo(no,last_name,first_name,email);
				
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void Insert(MailVo vo) {
		try {
			pstmt = conn.prepareStatement(INSERT);
			pstmt.setString(1, vo.getLast_name());
			pstmt.setString(2, vo.getFirst_name());
			pstmt.setString(3, vo.getEmail());
			cnt = pstmt.executeUpdate();
			
			if(cnt <= 0) {
				System.out.println("입력실패");
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
