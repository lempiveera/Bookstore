package com.example.Bookstrore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstrore.model.Book;
import com.example.Bookstrore.model.BookRepository;
import com.example.Bookstrore.model.Category;
import com.example.Bookstrore.model.CategoryRepository;
import com.example.Bookstrore.model.User;
import com.example.Bookstrore.model.UserRepository;

@SpringBootApplication
public class BookstroreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstroreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository brepository, CategoryRepository crepository,
			UserRepository urepository) {
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

			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "user@email.com","USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C","admin@email.com" ,"ADMIN");

			urepository.save(user1);
			urepository.save(user2);
			urepository.deleteAll();
			
		};
	}
}
