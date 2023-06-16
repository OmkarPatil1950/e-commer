package com.emart.controller;

public class Login {
	private String email_id;
	private String password;
	public String getemail_id() {
		return email_id;
	}
	public void setemail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
