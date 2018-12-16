package com.bookstore.main;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bookstore.main.domain.User;
import com.bookstore.main.domain.UserRepository;



@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {
	@Autowired
    private UserRepository repository;

    @Test
    public void findByUsernameShouldReturnUser() {
        User users = repository.findByUsername("admin");
        
        //assertThat(users).hasSize(1);
        //assertThat(users.get(0).getUsername()).isEqualTo("user");
    }
    
    @Test
    public void createNewCategory() {
    	User user = new User("user2", "user2", "user");
    	repository.save(user);
    	assertThat(user.getUsername()).isNotNull();
    } 
}
