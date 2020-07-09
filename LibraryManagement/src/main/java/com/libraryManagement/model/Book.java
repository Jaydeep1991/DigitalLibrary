package com.libraryManagement.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {

    @Id
    private long bookId;
    private String bookName;
    private String authorName;
    private double bookPrice;
    private String bookGenere;
    private Date fromDate;
    private Date toDate;
    private int numOfDays;

    
    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getBookGenere() {
        return bookGenere;
    }

    public void setBookGenere(String bookGenere) {
        this.bookGenere = bookGenere;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public int getNumOfDays() {
        return numOfDays;
    }

    public void setNumOfDays(int numOfDays) {
        this.numOfDays = numOfDays;
    }

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", authorName=" + authorName + ", bookPrice="
				+ bookPrice + ", bookGenere=" + bookGenere + ", fromDate=" + fromDate + ", toDate=" + toDate
				+ ", numOfDays=" + numOfDays + "]";
	}

  

}
