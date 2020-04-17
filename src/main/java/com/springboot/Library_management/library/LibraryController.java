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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LibraryController {
	@Autowired
	LibraryRepository libraryrepo;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping(path="/books")
	public ResponseEntity<Books> saveLibrary(@RequestBody Books library) {
		Books libraryobj= libraryrepo.save(library);
		return new ResponseEntity<Books>(libraryobj, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping(path="/books")
	@ResponseBody
	public List<Books> getLibrary() {
		return libraryrepo.findAll();
		
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@DeleteMapping("/books/{bookId}")
	public void deleteLibrary( @PathVariable int bookId ){
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
