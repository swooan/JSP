package test.web.model;

import java.sql.*;
import java.util.ArrayList;

import org.comstudy21.dbcp.JdbcUtil;

public class BoardDAO {
	
	private static BoardDAO instance;
	private BoardDAO(){};
	
	// 싱글톤 패턴
	public static BoardDAO getInstance() {
		if(instance == null) {
			instance = new BoardDAO();
		}
		return instance;
	}
	
	private Connection conn;
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;

	// num , author, email, title, content, passwd, writeday, readcnt, rep_root, rep_step, rep_indent
	String SQL_INSERT = "INSERT INTO BOARD VALUES(seq_board.nextval, ?, ?, ?, ?, ?, sysdate, 0, 0, 0, 0)";
	String SQL_SELECT = "SELECT * FROM BOARD ORDER BY NUM DESC";
	String SQL_CHOICE = "SELECT * FROM BOARD WHERE TITLE = ?";
	
	public ArrayList<BoardTO> list() {
		
		ArrayList<BoardTO> list = new ArrayList<BoardTO>();
		
		try {
			conn = JdbcUtil.getConnection(); // JNDI 커넥션 풀
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SQL_SELECT);
			while(rs.next()) {
				// 여기에 새 내용 추가
				int num = rs.getInt("num");
				String author = rs.getString("author");
				String email = rs.getString("email");
				String title = rs.getString("title");
				Timestamp writeday = rs.getTimestamp("writeday");
				BoardTO data = new BoardTO(num, author, email, title, null, null, writeday, 0, 0, 0, 0);
				list.add(data);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs, stmt, conn);
		}
		
		return list;
	}
	
	public BoardTO selectOne(BoardTO dto) {
		
		BoardTO saram = new BoardTO(0, SQL_INSERT, SQL_INSERT, SQL_INSERT, SQL_INSERT, SQL_INSERT, null, 0, 0, 0, 0);
		
		
		return saram;
	}
	
public ArrayList<BoardTO> select(BoardTO dto) {
		
		ArrayList<BoardTO> list = new ArrayList<BoardTO>();
		
		
		
		return null;
	}
	
	public void insert(BoardTO dto) {		
		try {
			conn = JdbcUtil.getConnection();
			pstmt = conn.prepareStatement(SQL_INSERT);
			
			// 여기에 새 내용 추가
			pstmt.setString(1, dto.getAuthor());
			pstmt.setString(2, dto.getEmail());
			pstmt.setString(3, dto.getTitle());
			pstmt.setString(4, dto.getContent());
			pstmt.setString(5, dto.getPasswd());
			
			int cnt = pstmt.executeUpdate();
			if(cnt <= 0) {
				System.out.println("입력 실패 : 이전 상황으로 되돌립니다.");
				conn.rollback();
			}
			else {
				System.out.println("입력 성공 : ");
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs, pstmt, conn);
		}
		
	}
	
	public void delete(BoardTO dto) {
		
	}
	
	public void update(BoardTO dto) {
		
	}
	
	// TDD - 테스트 주도 개발 (단위 별로 메인을 만들어서 실행해보자) => JUnit
	
	public static void test_selectAll() {

	}
	
	public static void test_insert(BoardTO dto) {

	}
	
	
}
