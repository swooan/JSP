package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MailVo;
import util.Util;

public class InsertCommand implements Command {

	@Override
	public String run(HttpServletRequest req, HttpServletResponse resp) {
		return "form";
	}
	
	public String update(HttpServletRequest req, HttpServletResponse resp) {
		
		String last_name = req.getParameter("ln");
		String first_name = req.getParameter("fn");
		String email = req.getParameter("email");
		
		MailVo vo = new MailVo(last_name,first_name, email);
		
		dao.setConnection(Util.getConnection());
		dao.Insert(vo);
		
		return "list";
	}

}
