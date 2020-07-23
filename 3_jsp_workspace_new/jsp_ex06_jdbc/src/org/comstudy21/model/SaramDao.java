package org.comstudy21.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.comstudy21.dbcp.JdbcUtil;

public class SaramDao {
	private static SaramDao instance;
	private SaramDao(){};
	
	// 싱글톤 패턴
	public static SaramDao getInstance() {
		if(instance == null) {
			instance = new SaramDao();
		}
		return instance;
	}
	
	private Connection conn;
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	String SQL_SELECT = "SELECT * FROM SARAM ORDER BY NO ASC";
	String SQL_INSERT = "INSERT INTO SARAM VALUES(SEQ_SARAM.nextval,?,?,?)";
	String SQL_DELETE = "DELETE FROM SARAM WHERE ? = ?";
	String SQL_UPDATE = "UPDATE SARAM SET ? = ?";
	
	
	public ArrayList<SaramDto> selectAll() {
		
		ArrayList<SaramDto> list = new ArrayList<SaramDto>();
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL_SELECT);
			while(rs.next()) {
				int no = rs.getInt(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				String phone = rs.getString(4);
								
				list.add(new SaramDto(no, name, email, phone));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs, stmt, conn);
		}
		
		return list;
	}
	
	public SaramDto selectOne(SaramDto dto) {
		
		SaramDto saram = new SaramDto();
		
		
		return saram;
	}
	
public ArrayList<SaramDto> select(SaramDto dto) {
		
		ArrayList<SaramDto> list = new ArrayList<SaramDto>();
		
		
		
		return null;
	}
	
	public void insert(SaramDto dto) {
		
		try {
			pstmt = conn.prepareStatement(SQL_INSERT);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getEmail());
			pstmt.setString(3, dto.getPhone());

			int cnt = pstmt.executeUpdate();
			if(cnt <= 0) {
				System.out.println("입력 실패 : 이전 상황으로 되돌립니다.");
				conn.rollback();
			}
			else {
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs, stmt, conn);
		}
		
	}
	
	public void delete(SaramDto dto) {
		
	}
	
	public void update(SaramDto dto) {
		
	}
	
	// TDD - 테스트 주도 개발 (단위 별로 메인을 만들어서 실행해보자) => JUnit
	
	public static void test_selectAll() {
		
		SaramDao dao = SaramDao.getInstance();
		dao.setConnection(JdbcUtil.getConnection());
		ArrayList<SaramDto> list = dao.selectAll();
		for(SaramDto dto : list) {
			System.out.println(dto);
		}
	}
	
	public static void test_insert(SaramDto dto) {
		SaramDao dao = SaramDao.getInstance();
		dao.setConnection(JdbcUtil.getConnection());
		dao.insert(dto);
	}
}
