package com.example.Bookstrore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.Bookstrore.model.Book;
import com.example.Bookstrore.model.BookRepository;
import com.example.Bookstrore.model.Category;
import com.example.Bookstrore.model.CategoryRepository;
import com.example.Bookstrore.model.User;
import com.example.Bookstrore.model.UserRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookstoreRepositoryTest {
	@Autowired
	private BookRepository brepository;

	@Autowired
	private CategoryRepository crepository;
	
	@Autowired
	private UserRepository urepository;
	
	@Test
	public void createNewBook() {
		Book book = new Book("title", "author", 1995, 12345, 12.3, new Category("fiction"));
		brepository.save(book);
		assertThat(book.getId()).isNotNull();
	}

	@Test
	public void findByTitleShouldReturnBook() {
		List<Book> books = brepository.findByTitle("HorrorBook");
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getAuthor()).isEqualTo("Author author");
	}
	
	@Test
	public void deleteBookByTitle() {
		long deletedBooks = brepository.deleteByTitle("HorrorBook");
		assertThat(deletedBooks).isEqualTo(1);
	}
	
	
	@Test
	public void createNewCategory() {
		Category category = new Category("Fantasy");
		crepository.save(category);
		assertThat(category.getCid()).isNotNull();
	}
	
	@Test
	public void findByNameShouldReturnCategory() {
		List<Category> categories = crepository.findByName("Horror");
		assertThat(categories).hasSize(1);
		assertThat(categories.get(0).getName()).isEqualTo("Horror");
	}
	
	@Test
	public void deleteCategoryByName() {
		long deletedCategories = crepository.deleteByName("Horror");
		assertThat(deletedCategories).isEqualTo(1);
	}
	
	@Test
	public void createNewUser() {
		User user = new User("user2", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "user@email.com","USER");
		urepository.save(user);
		assertThat(user.getId()).isNotNull();
	}
	
	@Test
	public void findByUsernameShouldReturnUser() {
		User user = urepository.findByUsername("user");
		assertThat(user.getUsername()).isEqualTo("user");
	}
	
	@Test
	public void deleteUserByUsername() {
		long deletedUsers = urepository.deleteByUsername("user");
		assertThat(deletedUsers).isEqualTo(1);
	}
}
