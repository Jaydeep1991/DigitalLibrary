package com.libraryManagement.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.libraryManagement.payload.BookGenere;
import com.libraryManagement.payload.BookGenereResponse;
import com.libraryManagement.repository.BookRepository;

@Service
public class DashBoardService {

    @Autowired
    private BookRepository bookRepo;

    public BookGenereResponse getBookForGenera() {
        List<Object[]> list = bookRepo.bookForGenere();
        List<BookGenere> book = new ArrayList<>();
        for (Object[] obj : list) {
            BookGenere bookObj = new BookGenere();
            java.math.BigInteger bookCount = (java.math.BigInteger) obj[0];
            bookObj.setBookCount(bookCount);
            bookObj.setBookGenere((String) obj[1]);
            book.add(bookObj);
        }
        if (book.isEmpty()) {
            return new BookGenereResponse(HttpStatus.BAD_REQUEST.value(), "No book genere found");
        }
        return new BookGenereResponse(HttpStatus.OK.value(), "Successfull", book);
    }

}
