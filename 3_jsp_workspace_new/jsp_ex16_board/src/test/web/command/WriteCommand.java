package test.web.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.web.model.BoardDAO;
import test.web.model.BoardTO;

public class WriteCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String author = request.getParameter("author");
		String email = request.getParameter("email");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String passwd = request.getParameter("passwd");
		
		BoardTO dto = new BoardTO(0, author, email, title, content, passwd, null, 0, 0, 0, 0);
		
		BoardDAO dao = BoardDAO.getInstance();
		dao.insert(dto);
	}

}
