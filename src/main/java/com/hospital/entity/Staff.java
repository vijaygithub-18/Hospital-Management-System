package com.hospital.entity;

public class Staff {

	private int id;
	private String fname;
	private String lname;
	private String role;
	private String department;
	private String email;
	private String phone;

	public Staff() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Staff(int id, String fname, String lname, String role, String department, String email,
			String phone) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.role = role;
		this.department = department;
		this.email = email;
		this.phone = phone;
	}

	public int getid() {
		return id;
	}

	public void setid(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Staff [id=" + id + ", fname=" + fname + ", lname=" + lname + ", role=" + role
				+ ", department=" + department + ", email=" + email + ", phone=" + phone + "]";
	}

}
