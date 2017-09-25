package pl.connectis.cschool.jcourse.restservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.connectis.cschool.jcourse.restservice.domain.Book;
import pl.connectis.cschool.jcourse.restservice.repository.BookRepository;

@RestController
@RequestMapping("/books")
public class BookController {
	
	private static final Logger logger = LoggerFactory.getLogger(BookController.class);
	
	@Autowired
	BookRepository bookRepository;
	
	@RequestMapping(method = RequestMethod.GET, value = "/{bookId}")
	Book findBook(@PathVariable Long bookId){
		return bookRepository.findOne(bookId);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	List<Book> allBook(){	
		return (List<Book>) bookRepository.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	ResponseEntity<Book> addBook(@RequestBody Book book) {	
		Book savedBook = bookRepository.save(book);
		return new ResponseEntity<Book>(savedBook, HttpStatus.OK);	
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{bookId}")
	ResponseEntity<Book> deleteBook(@PathVariable Long bookId) {
		bookRepository.delete(bookId);
		return new ResponseEntity<Book>(HttpStatus.OK);
	}	
}
