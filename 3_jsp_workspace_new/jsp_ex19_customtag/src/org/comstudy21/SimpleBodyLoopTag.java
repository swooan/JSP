package org.comstudy21;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SimpleBodyLoopTag extends SimpleTagSupport {
	
	String[] datas = {"유비","조조","손권"};

	@Override
	public void doTag() throws JspException, IOException {
		
		try {
			for(int i=0; i<datas.length; i++) {
				getJspContext().setAttribute("data", datas[i]);
				getJspBody().invoke(null);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
