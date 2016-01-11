package com.sample.training;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDetailsDAO {
	private Connection conn;

	private void init() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_training", "root", "password");
		conn.setAutoCommit(true);
	}

	public void createEmployee(EmployeeDetailsBean bean) {
		try {
			if (conn == null || conn.isClosed())
				init();
			PreparedStatement stmt = conn
					.prepareStatement("INSERT INTO `java_training`.`employee_details`(`emp_id`,`emp_f_name`,"
							+ "`emp_l_name`,`emp_dob`,`emp_sal`,`emp_profile_pic_path`,`emp_profile_cv_path`,"
							+ "`emp_desc`,`emp_gender`,`emp_addr_lat`,`emp_addr_long`,`emp_addr_str`)"
							+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
			stmt.setString(2, (bean.getfName() == null) ? null : bean.getfName());
			stmt.setString(3, (bean.getlName() == null) ? null : bean.getlName());
			stmt.setDate(4, (bean.getDob() == null) ? null : new Date(bean.getDob().getTime()));
			stmt.setDouble(5, (bean.getSal() == null) ? null : bean.getSal().doubleValue());
			stmt.setString(6, (bean.getProfilePicPath() == null) ? null : bean.getProfilePicPath());
			stmt.setString(7, (bean.getProfileCvPath() == null) ? null : bean.getProfileCvPath());
			stmt.setString(8, (bean.getDesc() == null) ? null : bean.getDesc());
			stmt.setString(9, (bean.getGender() == null) ? null : bean.getGender());
			stmt.setDouble(10, (bean.getAddrLat() == null) ? null : bean.getAddrLat().doubleValue());
			stmt.setDouble(11, (bean.getAddrLong() == null) ? null : bean.getAddrLong().doubleValue());
			stmt.setString(12, (bean.getAddrStr() == null) ? null : bean.getAddrStr());
			stmt.setLong(1, (bean.getId() == null) ? null : bean.getId());
			stmt.execute();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateEmployee(EmployeeDetailsBean bean) {
		try {
			if (conn == null || conn.isClosed())
				init();
			PreparedStatement stmt = conn
					.prepareStatement("UPDATE `java_training`.`employee_details` SET `emp_f_name` = ?,`emp_l_name` = ?,"
							+ "`emp_dob` = ?,`emp_sal` = ?,`emp_profile_pic_path` = ?,`emp_profile_cv_path` = ?,"
							+ "`emp_desc` = ?,`emp_gender` = ?,`emp_addr_lat` = ?,`emp_addr_long` = ?,"
							+ "`emp_addr_str` = ? WHERE `emp_id` = ?");
			stmt.setString(1, (bean.getfName() == null) ? null : bean.getfName());
			stmt.setString(2, (bean.getlName() == null) ? null : bean.getlName());
			stmt.setDate(3, (bean.getDob() == null) ? null : new Date(bean.getDob().getTime()));
			stmt.setDouble(4, (bean.getSal() == null) ? null : bean.getSal().doubleValue());
			stmt.setString(5, (bean.getProfilePicPath() == null) ? null : bean.getProfilePicPath());
			stmt.setString(6, (bean.getProfileCvPath() == null) ? null : bean.getProfileCvPath());
			stmt.setString(7, (bean.getDesc() == null) ? null : bean.getDesc());
			stmt.setString(8, (bean.getGender() == null) ? null : bean.getGender());
			stmt.setDouble(9, (bean.getAddrLat() == null) ? null : bean.getAddrLat().doubleValue());
			stmt.setDouble(10, (bean.getAddrLong() == null) ? null : bean.getAddrLong().doubleValue());
			stmt.setString(11, (bean.getAddrStr() == null) ? null : bean.getAddrStr());
			stmt.setLong(12, (bean.getId() == null) ? null : bean.getId());
			stmt.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<EmployeeDetailsBean> listEmployees() {
		ArrayList<EmployeeDetailsBean> ret = new ArrayList<EmployeeDetailsBean>();
		try {
			if (conn == null || conn.isClosed())
				init();
			PreparedStatement stmt = conn.prepareStatement("select * from `java_training`.`employee_details`");
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

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}
}
