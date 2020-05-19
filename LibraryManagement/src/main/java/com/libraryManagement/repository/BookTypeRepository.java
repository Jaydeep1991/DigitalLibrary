package com.libraryManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.libraryManagement.model.BookType;

@Repository
public interface BookTypeRepository extends JpaRepository<BookType, Integer> {

}
