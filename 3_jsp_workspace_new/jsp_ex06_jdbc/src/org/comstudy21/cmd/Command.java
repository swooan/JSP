package org.comstudy21.cmd;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy21.model.SaramDao;

public interface Command {
	String run(HttpServletRequest request, HttpServletResponse response);
	SaramDao dao = SaramDao.getInstance();
}
