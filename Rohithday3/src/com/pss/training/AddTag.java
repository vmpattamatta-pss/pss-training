package com.pss.training;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class AddTag extends SimpleTagSupport {
	private ComplexNumber firstNumber;
	private ComplexNumber secondNumber;
	private int ffirstpart;
	private int fsecondPart;
	private int sfirstpart;
	private int ssecondpart;

	public int getFfirstpart() {
		return ffirstpart;
	}

	public void setFfirstpart(int ffirstpart) {
		this.ffirstpart = ffirstpart;
	}

	public int getFsecondPart() {
		return fsecondPart;
	}

	public void setFsecondPart(int fsecondPart) {
		this.fsecondPart = fsecondPart;
	}

	public int getSfirstpart() {
		return sfirstpart;
	}

	public void setSfirstpart(int sfirstpart) {
		this.sfirstpart = sfirstpart;
	}

	public int getSsecondpart() {
		return ssecondpart;
	}

	public void setSsecondpart(int ssecondpart) {
		this.ssecondpart = ssecondpart;
	}

	public ComplexNumber getFirstNumber() {
		return firstNumber;
	}

	public void setFirstNumber(ComplexNumber firstNumber) {
		this.firstNumber = firstNumber;
	}

	public ComplexNumber getSecondNumber() {
		return secondNumber;
	}

	public void setSecondNumber(ComplexNumber secondNumber) {
		this.secondNumber = secondNumber;
	}

	@Override
	public void doTag() throws JspException, IOException {
		super.doTag();
		ComplexNumber complexNumber = new ComplexNumber();
		complexNumber.setReal(ffirstpart);
		complexNumber.setImaginary(fsecondPart);
		complexNumber.setReal(sfirstpart);
		complexNumber.setReal(ssecondpart);
		firstNumber = new ComplexNumber(ffirstpart, fsecondPart);
		secondNumber = new ComplexNumber(sfirstpart, ssecondpart);

		ComplexNumber result = new Execute().add(firstNumber, secondNumber);
		int real = result.getReal();
		int imag = result.getImaginary();
		getJspContext().getOut().print("Addition of "+ ffirstpart + "+i" + fsecondPart+"&nbsp;&nbsp;and&nbsp;&nbsp;"+ sfirstpart + "+i" + ssecondpart);
		getJspContext().getOut().write("&nbsp;&nbsp;is&nbsp;&nbsp; " + real + "+i" + imag);
		getJspContext().getOut().print("<br>");

	}
}
