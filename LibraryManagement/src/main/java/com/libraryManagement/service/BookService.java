package com.libraryManagement.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.libraryManagement.model.Book;
import com.libraryManagement.model.BookType;
import com.libraryManagement.payload.BookPayload;
import com.libraryManagement.payload.BookResponse;
import com.libraryManagement.repository.BookRepository;
import com.libraryManagement.repository.BookTypeRepository;

@Service
public class BookService {

    @Autowired
    private BookTypeRepository bookTypeRepo;

    @Autowired
    private BookRepository bookRepo;

    public BookPayload generateRandomBookId() {
        long randomNumber = (long) (Math.random() * Math.pow(9, 9));
        if (randomNumber > 0) {
            return new BookPayload(HttpStatus.OK.value(), randomNumber, "Success");
        } else {
            return new BookPayload(HttpStatus.BAD_REQUEST.value(), "Failed");
        }
    }

    public BookResponse showBooks() {

        List<BookType> list = bookTypeRepo.findAll();
        BookResponse response = new BookResponse();
        if (!list.isEmpty()) {
            response.setData(list);
            response.setMessage("Success");
            response.setStatusCode(HttpStatus.OK.value());
        } else {
            response.setMessage("Failed");
            response.setStatusCode(HttpStatus.BAD_REQUEST.value());
        }
        return response;
    }

    public BookResponse saveBooks(Book books) {

        if (books.getBookId() == 0 || books.getBookName() == null || books.getAuthorName() == null
                || books.getBookGenere() == null) {
            return new BookResponse(HttpStatus.NO_CONTENT.value(), "Field cannot be empty");
        }
        Boolean isBookExists = bookRepo.existsBybookName(books.getBookName());
        if (!isBookExists) {
            try {
                bookRepo.save(books);
                return new BookResponse(HttpStatus.OK.value(), "Saved Successfully");
            } catch (Exception ex) {
                return new BookResponse(HttpStatus.BAD_REQUEST.value(), "Failed to save");
            }
        } else {
            return new BookResponse(HttpStatus.BAD_REQUEST.value(), "Duplicate book Inventory");
        }
    }

    public BookResponse showAllBooks() {
        List<Book> list = bookRepo.findAll();
        if (list.isEmpty()) {
            return new BookResponse(HttpStatus.BAD_REQUEST.value(), "No Books Found");
        }
        return new BookResponse(HttpStatus.OK.value(), "Success", list);
    }

    public BookResponse checkDup(String bookName) {
        Boolean isBookExists = bookRepo.existsBybookName(bookName);
        if (isBookExists) {
            return new BookResponse(HttpStatus.CONFLICT.value(), "Book already exists");
        }
        return new BookResponse(HttpStatus.OK.value(), "Book doesnot exists");
    }

}
