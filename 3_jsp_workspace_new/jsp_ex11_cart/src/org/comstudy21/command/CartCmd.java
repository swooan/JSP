package org.comstudy21.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CartCmd implements Command {

	@Override
	public Resolve action(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		return new Resolve(false, "cart");
	}

}
