package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MemberDAO {

	private DataSource dataFactory;

	public MemberDAO() {
		try {
			Context ctx = new InitialContext();
			dataFactory = (DataSource) ctx.lookup("java:comp/env/jdbc/EmployeeDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public void insertMember(MemberBean m) {
		try {
			Connection con = dataFactory.getConnection();
			Statement stmt = con.createStatement();
			String name = m.getName();
			String age = m.getAge();
			String weight = m.getWeight();
			String height = m.getHeight();
			String gender = m.getGender();
			System.out.println("********************INSERT********************");
			String query = "INSERT INTO MEMBER VALUES (";
			query = query + "" + name + ", ";
			query = query + "" + age + ", ";
			query = query + "" + weight + ", ";
			query = query + "" + height + ", ";
			query = query + "" + gender + ")";
			stmt.executeUpdate(query);

			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public ArrayList showMember() {

		ArrayList list = new ArrayList<>();

		try {
			Connection con = dataFactory.getConnection();
			Statement stmt = con.createStatement();
			String query = "SELECT * FROM MEMBER";
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				String name = rs.getString("name");
				String age = rs.getString("age");
				String weight = rs.getString("weight");
				String height = rs.getString("height");
				String gender = rs.getString("gender");

				MemberTO domain = new MemberTO(name, age, weight, height, gender);
				list.add(domain);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
		}
		return list;
	}

}
