package com.springboot.Library_management.library;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.server.ResponseStatusException;

import com.springboot.Library_management.library.exception.BookNotFoundException;
import com.springboot.Library_management.library.exception.BooksExistsException;
@RestController
public class LibraryController {
	@Autowired
	BookService bookService;
	
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping(path="/books")
	public ResponseEntity<Books> addBooks(@RequestBody Books book) {
		 try{
			 bookService.addBooks(book);
			 return new ResponseEntity<Books>(HttpStatus.CREATED);
		 }
		 catch(BooksExistsException ex) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
			}
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping(path="/books")
	public List<Books> getAllBooks() {
		return bookService.getAllBooks();
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping(path="/books/{bookId}")
	public Optional<Books> getBooksById(@PathVariable("bookId") int bookId) {

		try {
			return bookService.getBooksById(bookId);
		} catch (BookNotFoundException ex) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
		}

	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@DeleteMapping(path="/books/{bookId}")
	public void deleteBooksbyId( @PathVariable int bookId ){
		bookService.deleteBooksById(bookId);	
	}
	
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PutMapping(path="/books/{bookId}")
	public Books updateBooksById(@PathVariable("bookId") int bookId, @RequestBody Books book) {

		try {
			return bookService.updateBooksById(bookId, book);
		} catch (BookNotFoundException ex) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
		}

	}
	
}
