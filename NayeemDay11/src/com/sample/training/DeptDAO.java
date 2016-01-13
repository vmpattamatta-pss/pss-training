package com.sample.training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DeptDAO {
	private Connection conn;

	private void init() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_training", "root", "password");
		conn.setAutoCommit(true);
	}

	public void createDept(DeptBean bean) {
		try {
			if (conn == null || conn.isClosed())
				init();
			PreparedStatement stmt = conn.prepareStatement(
					"INSERT INTO `java_training`.`dept`(`dept_id`,`dept_name`,`dept_mgr_id`) VALUES (?,?,?)");
			stmt.setLong(1, bean.getId());
			stmt.setString(2, bean.getName());
			stmt.setLong(3, (bean.getMgrId() == null) ? null : bean.getMgrId());
			stmt.execute();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void editDept(DeptBean bean) {
		try {
			if (conn == null || conn.isClosed())
				init();
			PreparedStatement stmt = conn.prepareStatement(
					"update `java_training`.`dept` set `dept_name`=?,`dept_mgr_id`=? where `dept_id`=?");
			stmt.setLong(3, bean.getId());
			stmt.setString(1, bean.getName());
			stmt.setLong(2, (bean.getMgrId() == null) ? null : bean.getMgrId());
			stmt.execute();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<DeptBean> listDept() {
		ArrayList<DeptBean> ret = new ArrayList<DeptBean>();
		try {
			if (conn == null || conn.isClosed())
				init();
			PreparedStatement stmt = conn.prepareStatement("select * from `java_training`.`dept`");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				DeptBean bean = new DeptBean();
				bean.setId(rs.getLong("dept_id"));
				bean.setName(rs.getString("dept_name"));
				bean.setMgrId(rs.getLong("dept_mgr_id"));
				ret.add(bean);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

}
