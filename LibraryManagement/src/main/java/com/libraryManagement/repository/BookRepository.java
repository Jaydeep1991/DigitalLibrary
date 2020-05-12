package com.libraryManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.libraryManagement.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
	
	public Boolean existsBybookName(String bookName);

}
