package com.bookstore.main;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bookstore.main.domain.Book;
import com.bookstore.main.domain.BookRepository;
import com.bookstore.main.domain.Category;


@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {
    @Autowired
    private BookRepository repository;

    @Test
    public void findByLastnameShouldReturnStudent() {
        List<Book> books = repository.findByAuthor("Author1");
        
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getTitle()).isEqualTo("Title1");
    }
    
    @Test
    public void createNewStudent() {
    	Book book = new Book("Book3", "Author3", "456789-7", 1999, 8, new Category("COMEDY"));
    	repository.save(book);
    	assertThat(book.getId()).isNotNull();
    }  
}
