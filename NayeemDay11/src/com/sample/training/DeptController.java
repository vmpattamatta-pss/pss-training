package com.sample.training;

import java.io.Serializable;
import java.util.List;

import org.primefaces.model.DualListModel;

public class DeptController implements Serializable {
	private static final long serialVersionUID = -160043755301971269L;
	private DeptBean bean;
	private DeptDAO dao;
	private EmployeeDetailsDAO empDao;
	private DeptEmpDAO deDao;
	private List<DeptBean> beans;
	private List<EmployeeDetailsBean> emps;
	private List<EmployeeDetailsBean> selEmps;
	private List<EmployeeDetailsBean> unselEmps;
	private Long selMgrId;
	private DualListModel<EmployeeDetailsBean> pickEmps;

	public String showCreate() {
		bean = null;
		return "createD";
	}

	public String showEdit() {
		getUnselEmps();
		getSelEmps();
		return "editD";
	}

	public String showView() {
		return "viewD";
	}

	public String createDept() {
		bean.setId(System.currentTimeMillis());
		getDao().createDept(bean);
		return "viewD";
	}

	public String editDept() {
		getDao().editDept(bean);
		getDeDao().updateEmp(bean.getId(), pickEmps.getTarget());
		return "viewD";
	}

	public DeptBean getBean() {
		if (bean == null)
			bean = new DeptBean();
		return bean;
	}

	public void setBean(DeptBean bean) {
		this.bean = bean;
	}

	public DeptDAO getDao() {
		if (dao == null)
			dao = new DeptDAO();
		return dao;
	}

	public void setDao(DeptDAO dao) {
		this.dao = dao;
	}

	public List<DeptBean> getBeans() {
		beans = getDao().listDept();
		return beans;
	}

	public void setBeans(List<DeptBean> beans) {
		this.beans = beans;
	}

	public EmployeeDetailsDAO getEmpDao() {
		if (empDao == null)
			empDao = new EmployeeDetailsDAO();
		return empDao;
	}

	public void setEmpDao(EmployeeDetailsDAO empDao) {
		this.empDao = empDao;
	}

	public List<EmployeeDetailsBean> getEmps() {
		emps = getEmpDao().listEmployees();
		return emps;
	}

	public void setEmps(List<EmployeeDetailsBean> emps) {
		this.emps = emps;
	}

	public List<EmployeeDetailsBean> getSelEmps() {
		selEmps = getDeDao().getEmployees(bean.getId());
		return selEmps;
	}

	public void setSelEmps(List<EmployeeDetailsBean> selEmps) {
		this.selEmps = selEmps;
	}

	public List<EmployeeDetailsBean> getUnselEmps() {
		unselEmps = getDeDao().getNonEmployees(bean.getId());
		return unselEmps;
	}

	public void setUnselEmps(List<EmployeeDetailsBean> unselEmps) {
		this.unselEmps = unselEmps;
	}

	public Long getSelMgrId() {
		return selMgrId;
	}

	public void setSelMgrId(Long selMgrId) {
		this.selMgrId = selMgrId;
	}

	public DeptEmpDAO getDeDao() {
		if (deDao == null)
			deDao = new DeptEmpDAO();
		return deDao;
	}

	public void setDeDao(DeptEmpDAO deDao) {
		this.deDao = deDao;
	}

	public DualListModel<EmployeeDetailsBean> getPickEmps() {
		pickEmps = new DualListModel<EmployeeDetailsBean>(unselEmps, selEmps);
		return pickEmps;
	}

	public void setPickEmps(DualListModel<EmployeeDetailsBean> pickEmps) {
		this.pickEmps = pickEmps;
	}

}
