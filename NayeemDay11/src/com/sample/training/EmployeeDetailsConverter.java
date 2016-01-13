package com.sample.training;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

public class EmployeeDetailsConverter implements Converter {
	private EmployeeDetailsDAO dao;

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		return getDao().getById(Long.valueOf(arg2));
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		EmployeeDetailsBean bean = getDao().getById((Long) arg2);
		return bean.getfName() + " - " + bean.getlName();
	}

	public EmployeeDetailsDAO getDao() {
		if (dao == null)
			dao = new EmployeeDetailsDAO();
		return dao;
	}

	public void setDao(EmployeeDetailsDAO dao) {
		this.dao = dao;
	}

}
