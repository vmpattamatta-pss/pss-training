package com.sample.training;

import java.io.Serializable;
import java.util.List;

import org.primefaces.event.FileUploadEvent;

public class EmployeeDetailsController implements Serializable {

	private static final long serialVersionUID = 1040894980592538271L;
	private EmployeeDetailsBean bean;
	private EmployeeDetailsDAO dao;
	private List<EmployeeDetailsBean> beans;

	public void handleProfilePicUpload(FileUploadEvent evt) {

	}

	public void handleProfileCvUpload(FileUploadEvent evt) {

	}

	public String showCreate() {
		bean = null;
		return "create";
	}

	public String showEdit() {
		return "edit";
	}

	public String showView() {
		return "view";
	}

	public String createEmployee() {
		bean.setId(System.currentTimeMillis());
		getDao().createEmployee(bean);
		return "view";
	}

	public String editEmployee() {
		getDao().updateEmployee(bean);
		return "view";
	}

	public EmployeeDetailsBean getBean() {
		if (bean == null)
			bean = new EmployeeDetailsBean();
		return bean;
	}

	public void setBean(EmployeeDetailsBean bean) {
		this.bean = bean;
	}

	public EmployeeDetailsDAO getDao() {
		if (dao == null)
			dao = new EmployeeDetailsDAO();
		return dao;
	}

	public void setDao(EmployeeDetailsDAO dao) {
		this.dao = dao;
	}

	public List<EmployeeDetailsBean> getBeans() {
		beans = getDao().listEmployees();
		return beans;
	}

	public void setBeans(List<EmployeeDetailsBean> beans) {
		this.beans = beans;
	}
}
