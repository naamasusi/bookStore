package com.bookstore.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.bookstore.main.domain.Book;
import com.bookstore.main.domain.BookRepository;
import com.bookstore.main.domain.Category;
import com.bookstore.main.domain.CategoryRepository;
import com.bookstore.main.domain.User;
import com.bookstore.main.domain.UserRepository;

@SpringBootApplication
public class MainApplication {
	
	private static final Logger log = LoggerFactory.getLogger(MainApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner studentDemo(BookRepository repository, CategoryRepository crepository, UserRepository urepository) {
		return (args) -> {
			log.info("save a couple of books");
			crepository.save(new Category("Horror"));
			crepository.save(new Category("Business"));
			crepository.save(new Category("Drama"));
			
			log.info("save a couple of books");
			repository.save(new Book("Book1", "Author1", "123456-7", 1923, 15, crepository.findByName("Horror").get(0)));
			repository.save(new Book("Book2", "Author2", "987654-3", 1977, 5, crepository.findByName("Drama").get(0)));
			
			// Create users: adminadmin useruser
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}

		};
	}
}

