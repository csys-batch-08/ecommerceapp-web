package com.ecommerceshoe.model;

import java.util.*;

public class Users {
	private int userid;
	private String Name;
	private String password;
	private Long mobileNo;
	private String email;
	private String Address;
	private Double wallet;

	
	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}
	

	public Double getWallet() {
		return wallet;
	}

	public void setWallet(Double wallet) {
		this.wallet = wallet;
	}

	public Users(String name, String password, Long mobileNo, String email, String address,double wallet) {
		super();
		Name = name;
		this.password = password;
		this.mobileNo = mobileNo;
		this.email = email;
		this.Address = address;
		this.wallet=wallet;
	}
	public Users(int userid, String name, String password, Long mobileNo, String email, String address,double wallet) {
		super();
		this.userid=userid;
		this.Name = name;
		this.password = password;
		this.mobileNo = mobileNo;
		this.email = email;
		this.Address = address;
		this.wallet=wallet;
	}
	public Users(String email) {
		super();
		this.email = email;
	}
	
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	

	@Override
	public String toString() {
		return "Users [Name=" + Name + ", password=" + password + ", mobileNo=" + mobileNo + ", email=" + email
				+ ", Address=" + Address + ",wallet="+wallet+"]";
	}

	
}
