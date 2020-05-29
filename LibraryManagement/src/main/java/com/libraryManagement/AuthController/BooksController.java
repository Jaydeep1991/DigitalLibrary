package com.libraryManagement.AuthController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.libraryManagement.model.Book;
import com.libraryManagement.service.BookService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/books")
public class BooksController {

    @Autowired
    private BookService bookService;

    @GetMapping("/getBookId")
    public ResponseEntity<?> generateBookId() {
        return ResponseEntity.ok(bookService.generateRandomBookId());
    }

    @GetMapping("/showAllBookType")
    public ResponseEntity<?> showBookType() {
        return ResponseEntity.ok(bookService.showBooks());
    }

    @PostMapping("/saveBook")
    public ResponseEntity<?> saveBook(@RequestBody Book book) {
        return ResponseEntity.ok(bookService.saveBooks(book));
    }

    @GetMapping("/showAllBooks")
    public ResponseEntity<?> showAllBooks() {
        return ResponseEntity.ok(bookService.showAllBooks());
    }

    @PostMapping("/checkDuplicateBookName")
    public ResponseEntity<?> checkDuplicateBookName(@RequestParam("bookName") String bookName) {
        return ResponseEntity.ok(bookService.checkDup(bookName));
    }

}
