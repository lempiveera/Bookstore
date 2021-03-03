package com.example.Bookstrore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstrore.model.Book;
import com.example.Bookstrore.model.BookRepository;
import com.example.Bookstrore.model.Category;
import com.example.Bookstrore.model.CategoryRepository;

@SpringBootApplication
public class BookstroreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstroreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository brepository, CategoryRepository crepository) {
		return (args) -> {
			Category a = new Category("Horror");
			Category b = new Category("Scifi");
			Category c = new Category("Biography");	

			crepository.save(a);
			crepository.save(b);
			crepository.save(c);
			
			Book i = new Book("HorrorBook", "Author author", 1995, 12356, 35.4, a);
			Book j = new Book("ScifiBook :)", "Writer writrer", 2021, 43827, 23.4, b);
			
			brepository.save(i);
			brepository.save(j);
			
		};
	}
}
