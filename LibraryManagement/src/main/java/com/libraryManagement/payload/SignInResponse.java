package com.libraryManagement.payload;

public class SignInResponse {
	
	private int statusCode;
	private String name;
	private String role;
	private String message;

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public SignInResponse() {
		super();
	}

	public SignInResponse(int statusCode, String name, String role, String message) {
		super();
		this.statusCode = statusCode;
		this.name = name;
		this.role = role;
		this.message = message;
	}
	public SignInResponse(int statusCode, String message) {
		super();
		this.statusCode = statusCode;
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	

}
