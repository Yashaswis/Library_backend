package com.springboot.Library_management.library;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;



@RestController
public class LibraryController {
	@Autowired
	LibraryRepository libraryrepo;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping(path="/books")
	public Books addBooks(@RequestBody Books book) {
		 libraryrepo.save(book);
		return book; 
	}
	
//	@CrossOrigin(origins = "http://localhost:3000")
//	@GetMapping(path="/books")
//	public List<Books> getAllBooks()
//	{
//		List<Books> book =new ArrayList<>();
//		libraryrepo.findAll().forEach(book :: add);
//	    return book;
//	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping(path="/books")
	public List<Books> getAllBooks() {
		return libraryrepo.findAll();
	}
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/books/{bookId}")
	public Books getBooks(@PathVariable int bookId)
	{
	   Optional<Books> libraryOpt  = libraryrepo.findById(bookId);
	   return libraryOpt.orElseThrow(() -> new RuntimeException("Data not found"));
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@DeleteMapping("/books/{bookId}")
	public void deleteBooks( @PathVariable int bookId ){
		  libraryrepo.deleteById(bookId);	
	}
	
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PutMapping("/books/{bookId}")
	public Books updateLibrary(@RequestBody Books library, @PathVariable int bookId)
	{
		Optional<Books> libraryOpt  = libraryrepo.findById(bookId);
		if (libraryOpt.isPresent()) {
			if (libraryOpt.get().getBookId() == bookId) {
				return libraryrepo.save(library);
			}
			else {
				throw new RuntimeException("Wrong User data ");
			}
		}
		else {
			throw new RuntimeException("No data found for update");
		}
	
		
	}
	
}
