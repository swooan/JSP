package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class JDBCUtil{

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	
	public static Connection getConnection() {
		Connection conn = null;

		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "hr";
		String pass = "hr";
		
			try{
				//Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDirverz");  //MS-sql
				//Class.forName("org.gjt.mm.msql.Driver");  //mySql
				Class.forName("oracle.jdbc.OracleDriver");
				conn = DriverManager.getConnection(url, user, pass);
				
			}catch(Exception e){
				e.printStackTrace();
			}
			return conn;
		}
			

	public static void close(ResultSet rs, Statement stmt, Connection conn) {
		close(rs);
		close(stmt);
		close(conn);
	}

	private static void close(Connection conn) {
		if(conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
	}

	private static void close(Statement stmt) {
		if(stmt != null)
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
	}

	private static void close(ResultSet rs) {
		if(rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
	}
	
}
