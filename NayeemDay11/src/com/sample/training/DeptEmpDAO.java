package com.sample.training;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DeptEmpDAO {
	private Connection conn;

	private void init() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_training", "root", "password");
		conn.setAutoCommit(true);
	}

	public void updateEmp(Long deptId, List<EmployeeDetailsBean> emps) {
		try {
			deleteEmployees(deptId);
			if (conn == null || conn.isClosed())
				init();
			for (EmployeeDetailsBean emp : emps) {
				PreparedStatement stmt = conn.prepareStatement(
						"INSERT INTO `java_training`.`dept_emp` (`de_id`,`de_dept_id`,`de_emp_id`) VALUES (?,?,?)");
				stmt.setString(1, UUID.randomUUID().toString());
				stmt.setLong(2, deptId);
				stmt.setLong(3, emp.getId());
				stmt.execute();
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<EmployeeDetailsBean> getEmployees(Long deptId) {
		ArrayList<EmployeeDetailsBean> ret = new ArrayList<EmployeeDetailsBean>();
		try {
			if (conn == null || conn.isClosed())
				init();
			PreparedStatement stmt = conn.prepareStatement(
					"select * from `java_training`.`employee_details` where `emp_id` in (select `de_emp_id` from `java_training`.`dept_emp` where `de_dept_id`=?)");
			stmt.setLong(1, deptId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				EmployeeDetailsBean bean = new EmployeeDetailsBean();
				bean.setAddrLat(new BigDecimal(rs.getDouble("emp_addr_lat")));
				bean.setAddrLong(new BigDecimal(rs.getDouble("emp_addr_long")));
				bean.setAddrStr(rs.getString("emp_addr_str"));
				bean.setDesc(rs.getString("emp_desc"));
				bean.setDob(rs.getDate("emp_dob"));
				bean.setfName(rs.getString("emp_f_name"));
				bean.setGender(rs.getString("emp_gender"));
				bean.setId(rs.getLong("emp_id"));
				bean.setlName(rs.getString("emp_l_name"));
				bean.setProfileCvPath(rs.getString("emp_profile_cv_path"));
				bean.setProfilePicPath(rs.getString("emp_profile_pic_path"));
				bean.setSal(new BigDecimal(rs.getDouble("emp_sal")));
				ret.add(bean);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

	public List<EmployeeDetailsBean> getNonEmployees(Long deptId) {
		ArrayList<EmployeeDetailsBean> ret = new ArrayList<EmployeeDetailsBean>();
		try {
			if (conn == null || conn.isClosed())
				init();
			PreparedStatement stmt = conn.prepareStatement(
					"select * from `java_training`.`employee_details` where `emp_id` not in (select `de_emp_id` from `java_training`.`dept_emp` where `de_dept_id`=?)");
			stmt.setLong(1, deptId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				EmployeeDetailsBean bean = new EmployeeDetailsBean();
				bean.setAddrLat(new BigDecimal(rs.getDouble("emp_addr_lat")));
				bean.setAddrLong(new BigDecimal(rs.getDouble("emp_addr_long")));
				bean.setAddrStr(rs.getString("emp_addr_str"));
				bean.setDesc(rs.getString("emp_desc"));
				bean.setDob(rs.getDate("emp_dob"));
				bean.setfName(rs.getString("emp_f_name"));
				bean.setGender(rs.getString("emp_gender"));
				bean.setId(rs.getLong("emp_id"));
				bean.setlName(rs.getString("emp_l_name"));
				bean.setProfileCvPath(rs.getString("emp_profile_cv_path"));
				bean.setProfilePicPath(rs.getString("emp_profile_pic_path"));
				bean.setSal(new BigDecimal(rs.getDouble("emp_sal")));
				ret.add(bean);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

	private void deleteEmployees(Long deptId) {
		try {
			if (conn == null || conn.isClosed())
				init();
			PreparedStatement stmt = conn
					.prepareStatement("delete from `java_training`.`dept_emp` where `de_dept_id`=?");
			stmt.setLong(1, deptId);
			stmt.execute();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

}
