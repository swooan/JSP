package org.comstudy21;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SimpleBodyTag extends SimpleTagSupport {
	@Override
	public void doTag() throws JspException, IOException {
		
		try {
			getJspContext().getOut().write("홍길동님");
			
			getJspBody().invoke(null);
			// null이면 다른 writer 가 아닌 response로 JSP의 body 내용을 전달한다.
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
