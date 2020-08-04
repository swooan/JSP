package org.comstudy21;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SimpleTag extends SimpleTagSupport{
	@Override
	public void doTag() throws JspException, IOException {
		try {
			getJspContext().getOut().print("SimpleTag 실습 예제 입니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
