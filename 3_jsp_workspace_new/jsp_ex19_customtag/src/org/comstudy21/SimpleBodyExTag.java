package org.comstudy21;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SimpleBodyExTag extends SimpleTagSupport {
	@Override
	public void doTag() throws JspException, IOException {
		try {
			getJspContext().setAttribute("message", "body에 표현식 예제!");
			getJspBody().invoke(null);
			// null이면 다른 writer가 아닌 response로 JSP의 body내용을 전달한다.
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
