package org.comstudy21.cmd;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy21.dbcp.JdbcUtil;
import org.comstudy21.model.SaramDto;

public class ListCommand implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		dao.setConnection(JdbcUtil.getConnection());
		ArrayList<SaramDto> list = dao.selectAll();
		request.setAttribute("LIST", list);
		
		return "list";
	}

}
