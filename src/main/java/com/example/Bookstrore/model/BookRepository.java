package com.example.Bookstrore.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
	
	List<Book> findByTitle(String title);
	long deleteByTitle(String title);
	
}
