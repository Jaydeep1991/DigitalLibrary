package com.libraryManagement.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.libraryManagement.model.Book;
import com.libraryManagement.model.BookType;
import com.libraryManagement.payload.BookPayload;
import com.libraryManagement.payload.BookResponse;
import com.libraryManagement.repository.BookRepository;
import com.libraryManagement.repository.BookTypeRepository;
import java.util.Iterator;

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

    public BookResponse dupBook(String bookName) {
        String userBook = bookName.toLowerCase().trim().replaceAll("\\s+", "");
        boolean flag = false;
        List<Book> bookObj = bookRepo.findAll();
        Iterator<Book> itr = bookObj.iterator();
        while (itr.hasNext()) {
            Book book = itr.next();
            if (book.getBookName().trim().replaceAll("\\s+", "").equals(userBook)) {
                flag = true;
                break;
            }
        }
        if (flag) {
            return new BookResponse(HttpStatus.CONFLICT.value(), "Book already exists");
        }
        return new BookResponse(HttpStatus.OK.value(), "Book doesnot exists");
    }

    public BookPayload deleteBook(Long bookId) {
        Optional<Book> bookObj = bookRepo.findById(bookId);
        if (!bookObj.isPresent()) {
            throw new RuntimeException("Book is not found");
        }
        Book book = bookObj.get();
        try {
            bookRepo.delete(book);
            return new BookPayload(HttpStatus.OK.value(), "Sucessfully delete book");
        } catch (Exception ex) {
            return new BookPayload(HttpStatus.BAD_REQUEST.value(), "Failed delete book");
        }
    }

    public BookResponse updateBookService(Book obj) {
        Optional<Book> bookObj = bookRepo.findById(obj.getBookId());
        if (!bookObj.isPresent()) {
            throw new RuntimeException("Book not found");
        }
        Book book = bookObj.get();
        boolean flag = false;
        if (obj.getBookName() != null) {
            List<Book> listBooks = bookRepo.findAll();
            Iterator<Book> itr = listBooks.iterator();
            while (itr.hasNext()) {
                Book book_Obj = itr.next();
                if (book.getBookName().trim().toLowerCase().replaceAll("\\s+", "").equals(book_Obj.getBookName().trim().toLowerCase().replaceAll("\\s+", ""))) {
                    flag = true;
                    break;
                }
            }
                if (flag) {
                    return new BookResponse(HttpStatus.BAD_REQUEST.value(), "Book already exists");
                } else {
                    book.setBookName(obj.getBookName());
                }
            }
        
        if (obj.getAuthorName() != null) {
            book.setAuthorName(obj.getAuthorName());
        }
        if (obj.getBookPrice() > 0) {
            book.setBookPrice(obj.getBookPrice());
        }
        if (obj.getBookGenere() != null) {
            book.setBookGenere(obj.getBookGenere());
        }
        if (flag == false) {
            try {
                bookRepo.save(book);
            } catch (Exception e) {
                return new BookResponse(HttpStatus.BAD_REQUEST.value(), "Unable to save");
            }
            return new BookResponse(HttpStatus.OK.value(), "Book details updated sucessfully");
        }
        return new BookResponse(HttpStatus.FOUND.value(), "No Change");
    }

}
