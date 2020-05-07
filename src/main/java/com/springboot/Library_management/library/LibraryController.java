package com.springboot.Library_management.library;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.Library_management.library.service.BookService;
@Component
@RestController

public class LibraryController {
	@Autowired
	private BookService bookService;
	
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping(path="/books")
	public ResponseEntity<BooksRequestDto> addBooks(@RequestBody BooksRequestDto book) {
		 bookService.addBooks(book);
		 return new ResponseEntity<BooksRequestDto>(HttpStatus.CREATED);
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping(path="/books")
	public List<BooksRequestDto> getAllBooks() {
		return (List<BooksRequestDto>) bookService.getAllBooks();
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping(path="/books/{bookId}")
	public Optional<BooksRequestDto> getBooksbyId(@PathVariable("bookId") int bookId) {
		return bookService.getBooksbyId(bookId);

	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@DeleteMapping(path="/books/{bookId}")
	public void deleteBooks( @PathVariable int bookId ){
		bookService.deleteBooks(bookId);	
	}
	
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PutMapping(path="/books/{bookId}")
	public BooksRequestDto updateBooks(@PathVariable("bookId") int bookId, @RequestBody BooksRequestDto book) {

		return bookService.updateBooks(bookId, book);

	}
	
}
