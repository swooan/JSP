package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MailDao;

public interface Command {
	String run(HttpServletRequest request, HttpServletResponse response);
	MailDao dao = MailDao.getInstance();
}
