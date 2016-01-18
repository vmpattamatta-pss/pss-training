package com.sample.training;

import java.io.Serializable;

public class CalcJSFModel implements Serializable {
	private static final long serialVersionUID = -8357644841791968151L;
	private int ffirstpart;
	private int fsecondPart;
	private int sfirstpart;
	private int ssecondpart;
	private int op;
	private int real;
	private int imaginary;

	public CalcJSFModel() {

	}

	public CalcJSFModel(int real, int imaginary) {

		this.real = real;
		this.imaginary = imaginary;
	}

	public CalcJSFModel(int ffirstpart, int fsecondPart, int sfirstpart, int ssecondpart, int op) {

		this.ffirstpart = ffirstpart;
		this.fsecondPart = fsecondPart;
		this.sfirstpart = sfirstpart;
		this.ssecondpart = ssecondpart;
		this.op = op;
	}

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

	public int getOp() {
		return op;
	}

	public void setOp(int op) {
		this.op = op;
	}

	public int getReal() {
		return real;
	}

	public void setReal(int real) {
		this.real = real;
	}

	public int getImaginary() {
		return imaginary;
	}

	public void setImaginary(int imaginary) {
		this.imaginary = imaginary;
	}

}
