package com.cmsEdge.Beans;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class LogProccessBean {
	private MultipartFile uploadFile;
	@NotEmpty(message="Date should not be empty")
	private String dtUploadFile;
	private String logname;
	private String errorFileName;

	public MultipartFile getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}

	public String getDtUploadFile() {
		return dtUploadFile;
	}

	public void setDtUploadFile(String dtUploadFile) {
		this.dtUploadFile = dtUploadFile;
	}

	public String getLogname() {
		return logname;
	}

	public void setLogname(String logname) {
		this.logname = logname;
	}

	public String getErrorFileName() {
		return errorFileName;
	}

	public void setErrorFileName(String errorFileName) {
		this.errorFileName = errorFileName;
	}


}
