package com.parohyapp.api.beans;

public class PasswordBean {
	
	private String id;
	private String password;
	private String passwordRe;
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordRe() {
		return passwordRe;
	}
	public void setPasswordRe(String passwordRe) {
		this.passwordRe = passwordRe;
	}
	public int getStringId(){
		return Integer.parseInt(id);
	}
	
}
