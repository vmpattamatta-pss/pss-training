package com.cmsEdge.Beans;

import org.springframework.web.multipart.MultipartFile;

public class LogProccessBean {
	private MultipartFile uploadFile;
	private String dtUploadFile;

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

}
