package com.bookstore.main;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bookstore.main.web.BookController;
import com.bookstore.main.web.MessageController;
import com.bookstore.main.web.UserController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MainApplicationTests {
	
    @Autowired
    private BookController controller;
    @Autowired
    private MessageController controller2;
    @Autowired
    private UserController controller3;
	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
		assertThat(controller2).isNotNull();
		assertThat(controller3).isNotNull();
		
	}

}

