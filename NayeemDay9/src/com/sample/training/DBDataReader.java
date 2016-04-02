package com.sample.training;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.DatabaseMetaData;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class DBDataReader {
	private String uName;
	private String pwd;
	private String selSchema;
	private String selTable;
	private List<String> catalogs;
	private List<String> tables;
	private List<List<String>> data;
	private boolean disData;

	public String doLogin() {
		disData = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306", uName, pwd);
			DatabaseMetaData md = con.getMetaData();
			ResultSet rs = md.getCatalogs();
			catalogs = new ArrayList<String>();
			while (rs.next()) {
				catalogs.add(rs.getString(1));
			}
		} catch (Exception e) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return "";
		}
		return "success";
	}

	public void doCatalogChange(AjaxBehaviorEvent evt) {
		disData = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + selSchema, uName, pwd);
			DatabaseMetaData md = con.getMetaData();
			ResultSet rs = md.getTables(null, null, "%", null);
			tables = new ArrayList<String>();
			while (rs.next()) {
				tables.add(rs.getString(3));
			}
		} catch (Exception e) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	public void doTableChange(AjaxBehaviorEvent evt) {
		disData = true;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + selSchema, uName, pwd);
			Statement st = con.createStatement();
			DatabaseMetaData metaData = con.getMetaData();
			ResultSet rsmd = metaData.getColumns(null, null, selTable, null);
			ArrayList<String> columnList = new ArrayList<String>();
			while (rsmd.next()) {
				columnList.add(rsmd.getString("COLUMN_NAME"));
			}
			data = new ArrayList<List<String>>();
			data.add(columnList);
			String query = "select * from " + selSchema + "." + selTable + ";";
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				ArrayList<String> tableData = new ArrayList<String>();
				for (String column : columnList) {
					tableData.add(rs.getString(column));
				}
				data.add(tableData);
			}
		} catch (Exception e) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getSelSchema() {
		return selSchema;
	}

	public void setSelSchema(String selSchema) {
		this.selSchema = selSchema;
	}

	public String getSelTable() {
		return selTable;
	}

	public void setSelTable(String selTable) {
		this.selTable = selTable;
	}

	public List<String> getCatalogs() {
		return catalogs;
	}

	public void setCatalogs(List<String> catalogs) {
		this.catalogs = catalogs;
	}

	public List<String> getTables() {
		return tables;
	}

	public void setTables(List<String> tables) {
		this.tables = tables;
	}

	public List<List<String>> getData() {
		return data;
	}

	public void setData(List<List<String>> data) {
		this.data = data;
	}

	public boolean isDisData() {
		return disData;
	}

	public void setDisData(boolean disData) {
		this.disData = disData;
	}
}
