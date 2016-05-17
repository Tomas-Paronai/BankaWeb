package com.parohyapp.api;

public class PasswordBean {
	
	private String password;
	private String passwordRe;
	private int clientId;
	
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
	public int getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = HashGen.findUserId(clientId);
	}
	
	
}
