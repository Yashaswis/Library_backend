package com.springboot.Library_management.library;
import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.Library_management.library.exception.BooksExistsException;
import com.springboot.Library_management.library.exception.ResourceNotFoundException;
import com.springboot.Library_management.library.service.BookService;
@RestController

public class LibraryController {
	@Autowired
	private BookService bookService;
	
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping(path="/books")
	public ResponseEntity<Books> addBooks(@Valid @RequestBody Books book) throws BooksExistsException {
		 return new ResponseEntity<Books>(bookService.addBooks(book),HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping(path="/books")
	public ResponseEntity<List<Books>> getAllBooks() {
		List<Books> list = bookService.getAllBooks();
		return new ResponseEntity<List<Books>>(list, new HttpHeaders(),HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping(path="/books/{bookId}")
	public ResponseEntity<Books> getBooksbyId(@PathVariable(value="bookId") int bookId) throws ResourceNotFoundException {
		Books book = bookService.getBooksbyId(bookId);
        return new ResponseEntity<Books>(book, new HttpHeaders(),HttpStatus.OK);

	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@DeleteMapping(path="/books/{bookId}")
	public HttpStatus deleteBooks( @PathVariable int bookId )throws ResourceNotFoundException{
		bookService.deleteBooks(bookId);
		return HttpStatus.FORBIDDEN;
	}
	
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PutMapping(path="/books/{bookId}")
	public ResponseEntity<Books> updateBooks(@PathVariable("bookId") int bookId,@Valid @RequestBody Books book) throws ResourceNotFoundException {
		Books books = bookService.updateBooks(bookId,book);
		return new ResponseEntity<Books>(books, new HttpHeaders(),HttpStatus.OK);

	}
	
}
