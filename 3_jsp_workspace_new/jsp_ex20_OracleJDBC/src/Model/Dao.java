package Model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Dao implements BookShopDao {
	
	private static Dao instance;
	private Dao() {};
	
	public static Dao getInstance() {
		if(instance == null) {
			instance = new Dao();
		}
		return instance;
	}
	
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
		
	  public void setConnection(Connection conn) { this.conn = conn; }
	 
	
	String ShowAll = "select b.book_id, b.title, b.pubs, b.pub_date, a.author_name from book b, author a where b.author_id = a.author_id";
	String Search = "select b.book_id, b.title, b.pubs, b.pub_date, a.author_name from book b autrhor a where b.author_id = a.author_id AND a.author_name LIKE '%'||?||'%'";
	
	public ArrayList<Dto> Show() {
		
		ArrayList<Dto> list = new ArrayList<Dto>();
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(ShowAll);
			
			while(rs.next()) {
				int book_id = rs.getInt(1);
				String title = rs.getString(2);
				String pubs = rs.getString(3);
				Date pub_date = rs.getDate(4);
				String author_name = rs.getString(5);
				
				list.add(new Dto(book_id, title, pubs, pub_date, author_name));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	public ArrayList<Dto> Search(Dto dto) {
		ArrayList<Dto> slist = new ArrayList<Dto>();
		
		try {
			pstmt = conn.prepareStatement(Search);
			pstmt.setString(1, dto.getAuthor_name());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int book_id = rs.getInt(1);
				String title = rs.getString(2);
				String pubs = rs.getString(3);
				Date pub_date = rs.getDate(4);
				String author_name = rs.getString(5);
				
				slist.add(new Dto(book_id, title, pubs, pub_date, author_name));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return slist;
	}

	@Override
	public void Insert(Dto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Update(Dto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Delete(Dto dto) {
		// TODO Auto-generated method stub
		
	}
	
}
