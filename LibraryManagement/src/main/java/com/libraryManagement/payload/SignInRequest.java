package com.libraryManagement.payload;

public class SignInRequest {
	
	private String userNameEmail;
	private String password;
	
	public String getUserNameEmail() {
		return userNameEmail;
	}
	public void setUserNameEmail(String userNameEmail) {
		this.userNameEmail = userNameEmail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
