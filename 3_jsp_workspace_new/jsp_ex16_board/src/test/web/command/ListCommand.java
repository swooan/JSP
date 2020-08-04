package test.web.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.web.model.BoardDAO;
import test.web.model.BoardTO;

public class ListCommand implements Command {
	/* (non-Javadoc)
	 * @see test.web.command.Command#execute(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("ListCommand 호출");
		
		BoardDAO dao = BoardDAO.getInstance();
		ArrayList<BoardTO> list = dao.list();
		System.out.println("list.size() => " + list.size());
		request.setAttribute("list", list);
	}
}
