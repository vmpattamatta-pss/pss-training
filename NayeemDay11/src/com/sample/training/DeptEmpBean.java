package com.sample.training;

import java.io.Serializable;

public class DeptEmpBean implements Serializable {

	private static final long serialVersionUID = -2147292696498054886L;
	private String id;
	private Long deptId;
	private Long empId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}
}
