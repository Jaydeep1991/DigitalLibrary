package com.libraryManagement.payload;

import java.util.ArrayList;
import java.util.List;

public class BookGenereResponse {
	
	private int statusCode;
	private String message;
	private List<BookGenere>data=new ArrayList<>();
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<BookGenere> getData() {
		return data;
	}
	public void setData(List<BookGenere> data) {
		this.data = data;
	}
	public BookGenereResponse(int statusCode, String message, List<BookGenere> data) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.data = data;
	}
	public BookGenereResponse() {
		super();
	}
	public BookGenereResponse(int statusCode, String message) {
		super();
		this.statusCode = statusCode;
		this.message = message;
	}
	

}
