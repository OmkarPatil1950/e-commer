package com.emart.entities;

public class AdminLogin {
	private String emailId;
	private String password;
	public String getemailId() {
		return emailId;
	}
	public void setemail_id(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
