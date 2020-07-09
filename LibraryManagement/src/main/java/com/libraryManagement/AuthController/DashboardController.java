package com.libraryManagement.AuthController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.libraryManagement.service.DashBoardService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class DashboardController {

    @Autowired
    private DashBoardService dashService;

    @GetMapping("/bookForGenere")
    private ResponseEntity<?> getBooksForBookType() {
        return ResponseEntity.ok(dashService.getBookForGenera());
    }   
}
