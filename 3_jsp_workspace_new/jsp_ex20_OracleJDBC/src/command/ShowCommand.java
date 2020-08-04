package command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Dto;
import Util.JDBCUtil;

public class ShowCommand implements Command {

	@Override
	public String run(HttpServletRequest req, HttpServletResponse resp) {
		
		dao.setConnection(JDBCUtil.getConnection());
		
		System.out.println("1234");
		ArrayList<Dto> list = dao.Show();
		req.setAttribute("list", list);
		
		return "list";
		
	}

}
