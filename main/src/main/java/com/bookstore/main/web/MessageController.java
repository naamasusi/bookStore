package com.bookstore.main.web;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.main.domain.Message;

@RestController
public class MessageController {
	
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/hello")
	public Message msg(@RequestParam(value="name", defaultValue="World") String name) {
		return new Message(counter.incrementAndGet(), "Hello " + name);
	}
}
