package com.sample.training;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ModTag extends SimpleTagSupport {

	private String inpA;
	private String inpB;

	@Override
	public void doTag() throws JspException, IOException {
		super.doTag();
		getJspContext().getOut().write("Modulus of InpA :: " + inpA + " and InpB :: " + inpB + " is :: "
				+ String.valueOf(Integer.parseInt(inpA) % Integer.parseInt(inpB)));
	}

	public String getInpA() {
		return inpA;
	}

	public void setInpA(String inpA) {
		this.inpA = inpA;
	}

	public String getInpB() {
		return inpB;
	}

	public void setInpB(String inpB) {
		this.inpB = inpB;
	}

}
