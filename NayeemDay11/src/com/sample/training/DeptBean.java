package com.sample.training;

import java.io.Serializable;

public class DeptBean implements Serializable {
	private static final long serialVersionUID = 7887247745264273295L;
	private Long id;
	private String name;
	private Long mgrId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getMgrId() {
		return mgrId;
	}

	public void setMgrId(Long mgrId) {
		this.mgrId = mgrId;
	}
}
