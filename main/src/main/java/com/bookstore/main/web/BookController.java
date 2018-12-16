package com.bookstore.main.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bookstore.main.domain.Book;
import com.bookstore.main.domain.BookRepository;
import com.bookstore.main.domain.CategoryRepository;

@Controller
public class BookController {
	
	@Autowired
		private BookRepository repository;
	
	@Autowired
	private CategoryRepository crepository; 
		
		//LogIn
		@RequestMapping(value="/login")
		public String login() {
			return "login";
		}
		
		// Show all books
	    @RequestMapping(value="/booklist")
	    public String bookList(Model model) {	
	    	model.addAttribute("books", repository.findAll());
	    return "booklist";
	    }
	    
	    // Add new book
	    @PreAuthorize("hasAuthority('ADMIN')")
	    @RequestMapping(value = "/add")
	    public String addBook(Model model){
	    	model.addAttribute("book", new Book());
	    	model.addAttribute("categories", crepository.findAll());
	    	return "addbook";
	    }
	    
	    // Edit book
	    @RequestMapping(value = "/edit")
	    public String editBook(@PathVariable("id") Long bookId, Model model) {
	    	repository.findById(bookId);
	    	return "edit";
	    }  
	    
	    @RequestMapping(value = "/save", method = RequestMethod.POST)
	    public String save(Book book){
	        repository.save(book);
	        return "redirect:booklist";
	    }    

	    @PreAuthorize("hasAuthority('ADMIN')")
	    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
	    	repository.deleteById(bookId);
	        return "redirect:../booklist";
	    }
	    
	    // RESTFULL to get books
	    @RequestMapping(value="/books", method = RequestMethod.GET)
	    public @ResponseBody List<Book> booksListRest() {
	    	return (List<Book>) repository.findAll();
	    }
	    
	    //RESTFULL for  books by id
	    @RequestMapping(value="/book/{id}", method = RequestMethod.GET)
	    public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long bookId) {
	    	return repository.findById(bookId);
	    }
}
