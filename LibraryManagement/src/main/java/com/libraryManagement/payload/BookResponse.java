package com.libraryManagement.payload;

import java.util.ArrayList;
import java.util.List;

import com.libraryManagement.model.Book;
import com.libraryManagement.model.BookType;

public class BookResponse {

	private int statusCode;
	private String message;
	private List<BookType>data=new ArrayList<>();
	private List<Book>dataBook=new ArrayList<>();

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
	public List<BookType> getData() {
		return data;
	}
	public void setData(List<BookType> data) {
		this.data = data;
	}
	public BookResponse(int statusCode, String message) {
		super();
		this.statusCode = statusCode;
		this.message = message;
	}

	public BookResponse() {
		super();
	}
	public List<Book> getDataBook() {
		return dataBook;
	}
	public void setDataBook(List<Book> dataBook) {
		this.dataBook = dataBook;
	}
	public BookResponse(int statusCode, String message, List<Book> dataBook) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.dataBook = dataBook;
	}	
}
