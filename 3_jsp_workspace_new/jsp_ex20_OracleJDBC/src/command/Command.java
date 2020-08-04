package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Dao;

public interface Command {
	String run(HttpServletRequest req, HttpServletResponse resp);
	Dao dao = Dao.getInstance();
}
