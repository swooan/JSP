package org.comstudy21.cmd;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy21.dbcp.JdbcUtil;
import org.comstudy21.model.SaramDto;

public class InsertCommand implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		// doGet 에서 호출
		return "form";
	}

	public String update(HttpServletRequest request, HttpServletResponse response) {
		// doPost 에서 호출
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		SaramDto dto = new SaramDto(0, name, email, phone);
		
		dao.setConnection(JdbcUtil.getConnection());
		dao.insert(dto);
		
		return "list"; // view name
	}
	
	

}
