package com.ecommerceshoe.model;

import java.io.Serializable;

public class Admin implements Serializable {
	private String adminEmail;
	private String password;

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Admin(String adminEmail, String password) {
		super();
		this.adminEmail = adminEmail;
		this.password = password;
	}

	public Admin() {
		super();

	}

	@Override
	public String toString() {
		return "Admin [adminEmail=" + adminEmail + ", password=" + password + "]";
	}

}
