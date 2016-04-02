package com.cmsEdge.Beans;

public class ErrorBean {
	private String errors,date,level,location,blank,errordesc;
private int ErrorId;
	public ErrorBean(String date, String level, String location, String blank, String errordesc) {
		super();
		
		this.date = date;
		this.level = level;
		this.location = location;
		this.blank = blank;
		this.errordesc = errordesc;
	}

	public String getErrors() {
		return errors;
	}

	public void setErrors(String errors) {
		this.errors = errors;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getBlank() {
		return blank;
	}

	public void setBlank(String blank) {
		this.blank = blank;
	}

	public String getErrordesc() {
		return errordesc;
	}

	public void setErrordesc(String errordesc) {
		this.errordesc = errordesc;
	}

	public int getErrorId() {
		return ErrorId;
	}

	public void setErrorId(int errorId) {
		this.ErrorId = errorId;
	}

	

}
