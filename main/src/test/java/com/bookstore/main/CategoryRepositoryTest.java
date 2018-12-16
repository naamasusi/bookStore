package com.bookstore.main;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bookstore.main.domain.Category;
import com.bookstore.main.domain.CategoryRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryTest {
    @Autowired
    private CategoryRepository repository;

    @Test
    public void findByNameShouldReturnCategory() {
        List<Category> categories = repository.findByName("Horror");
        
        assertThat(categories).hasSize(1);
        assertThat(categories.get(0).getName()).isEqualTo("Business");
    }
    
    @Test
    public void createNewCategory() {
    	Category category = new Category("Jokes");
    	repository.save(category);
    	assertThat(category.getName()).isNotNull();
    } 
}
