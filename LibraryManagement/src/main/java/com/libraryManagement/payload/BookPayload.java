package com.libraryManagement.payload;

public class BookPayload {
	
	private int statusCode;
	private long registrationNumber;
	private String message;
	
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public long getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(long registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public BookPayload() {
		super();
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public BookPayload(int statusCode, long registrationNumber, String message) {
		super();
		this.statusCode = statusCode;
		this.registrationNumber = registrationNumber;
		this.message = message;
	}
	public BookPayload(int statusCode, String message) {
		super();
		this.statusCode = statusCode;
		this.message = message;
	}
	
	

}
