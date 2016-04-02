package com.cmsEdge.Beans;

import java.util.List;

public class Pojo {
	//@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private int logId;
	private List<String> RecordsList;
	private String errors,date,level,location,blnk,errordesc;

	public int getLogId() {
		return logId;
	}

	public void setLogId(int logId) {
		this.logId = logId;
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

	public String getBlnk() {
		return blnk;
	}

	public void setBlnk(String blnk) {
		this.blnk = blnk;
	}

	public String getErrordesc() {
		return errordesc;
	}

	public void setErrordesc(String errordesc) {
		this.errordesc = errordesc;
	}

	public List<String> getRecordsList() {
		return RecordsList;
	}

	public void setRecordsList(List<String> recordsList) {
		RecordsList = recordsList;
	}


	

}
