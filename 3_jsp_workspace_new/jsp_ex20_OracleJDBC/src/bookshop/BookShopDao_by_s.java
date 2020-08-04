package bookshop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookshop.BookShopVo_by_s;

public class BookShopDao_by_s {

	public List<BookShopVo_by_s> getList() {

		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BookShopVo_by_s> list = new ArrayList<BookShopVo_by_s>();

		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "hr", "hr");
			
			// 3. SQL문 준비 / 바인딩 / 실행
			String query = "select \r\n" + 
					"    b.book_id, \r\n" + 
					"    b.title, \r\n" + 
					"    b.pubs, \r\n" + 
					"    b.pub_date, \r\n" + 
					"    a.author_name\r\n" + 
					"from book b, author a\r\n" + 
					"where b.author_id = a.author_id" ;
			pstmt = conn.prepareStatement(query);
			
			rs = pstmt.executeQuery();
			// 4.결과처리
			while(rs.next()) {
				int book_id = rs.getInt("book_id");
				String title = rs.getString("title");
				String pubs = rs.getString("pubs");
				String pub_date = rs.getString("pub_date");
				String author_name = rs.getString("author_name");
				
				BookShopVo_by_s vo = new BookShopVo_by_s(book_id, title, pubs, pub_date, author_name);
				list.add(vo);
			}
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			// 5. 자원정리
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("error:" + e);
			}

		}

		return list;
	}

}
