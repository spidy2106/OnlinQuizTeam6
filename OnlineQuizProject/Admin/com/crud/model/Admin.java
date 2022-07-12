package com.crud.model;

import java.util.Date;

public class Admin {

	private int id;
	private String adminname;
	private Date dob;
	private String email;
	private int phone;
	private String address;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAdminname() {
		return adminname;
	}
	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Admin(int id, String adminname, Date dob, String email, int phone, String address) {
		super();
		this.id = id;
		this.adminname = adminname;
		this.dob = dob;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}
	
	
}
