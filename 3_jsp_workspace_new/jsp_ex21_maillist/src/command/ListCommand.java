package command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MailVo;
import util.Util;

public class ListCommand implements Command {

	@Override
	public String run(HttpServletRequest request, HttpServletResponse response) {
		dao.setConnection(Util.getConnection());
		ArrayList<MailVo> list = dao.List();
		request.setAttribute("LIST", list);
		
		return "list";
	}

}
