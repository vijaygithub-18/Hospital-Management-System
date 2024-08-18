package com.hospital.entity;

public class Patient {

	  private int id;
	  private String fullname;
	  private String email;
	  private String password;
	  
	  
	  
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Patient(String fullname, String email, String password) {
		super();
		this.fullname = fullname;
		this.email = email;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getfullname() {
		return fullname;
	}
	public void setfullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	  
	  
}
