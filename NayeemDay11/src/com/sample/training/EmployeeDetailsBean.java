package com.sample.training;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class EmployeeDetailsBean implements Serializable {
	private static final long serialVersionUID = 2512602862977301956L;
	private Long id;
	private String fName;
	private String lName;
	private Date dob;
	private BigDecimal sal;
	private String profilePicPath;
	private String profileCvPath;
	private String desc;
	private String gender;
	private BigDecimal addrLat;
	private BigDecimal addrLong;
	private String addrStr;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public BigDecimal getSal() {
		return sal;
	}

	public void setSal(BigDecimal sal) {
		this.sal = sal;
	}

	public String getProfilePicPath() {
		return profilePicPath;
	}

	public void setProfilePicPath(String profilePicPath) {
		this.profilePicPath = profilePicPath;
	}

	public String getProfileCvPath() {
		return profileCvPath;
	}

	public void setProfileCvPath(String profileCvPath) {
		this.profileCvPath = profileCvPath;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public BigDecimal getAddrLat() {
		return addrLat;
	}

	public void setAddrLat(BigDecimal addrLat) {
		this.addrLat = addrLat;
	}

	public BigDecimal getAddrLong() {
		return addrLong;
	}

	public void setAddrLong(BigDecimal addrLong) {
		this.addrLong = addrLong;
	}

	public String getAddrStr() {
		return addrStr;
	}

	public void setAddrStr(String addrStr) {
		this.addrStr = addrStr;
	}
}
