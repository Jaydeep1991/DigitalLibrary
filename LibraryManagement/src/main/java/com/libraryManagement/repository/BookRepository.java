package com.libraryManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.libraryManagement.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
	
	public Boolean existsBybookName(String bookName);
	
	@Query(value="select count(*),book_genere from book group by book_genere;",nativeQuery = true)
	public List<Object[]> bookForGenere(); 

}
