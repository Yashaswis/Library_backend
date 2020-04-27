package com.springboot.Library_management;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.Library_management.library.exception.BookNotFoundException;
import com.springboot.Library_management.library.exception.BooksExistsException;
import com.springboot.Library_management.library.Books;
import com.springboot.Library_management.library.LibraryRepository;
@Service
public class BookService {
	@Autowired 
	LibraryRepository libraryRespository;
	
	public List<Books> getAllBooks()
	{  
		return libraryRepository.findAll();  
	} 
	
	
	public Optional<Books> getBooksById(int bookId) throws BookNotFoundException {
		Optional<Books> book = libraryRepository.findById(bookId);

		if (!book.isPresent()) {
			throw new BookNotFoundException("Book Not found in book Repository");
		}

		return book;
	}
	
	public Books addBooks(Books book) throws BooksExistsException{
		
		Books existingBooks = libraryRepository.findByBookname(book.getBookname());
	
		//if not exists throw BooksExistsException
		if(existingBooks != null) {
			throw new BooksExistsException("Book already exists in repository");
		}
		
	
		return libraryRepository.save(book);
	}
	
	public void deleteBooksById(int bookId) {
		Optional<Books> optionalBook = libraryRepository.findById(bookId);
		if (!optionalBook.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Book Not found in book Repository, provide the correct book id");
		}
	
		libraryRepository.deleteById(bookId);
	} 
	
	
	public Books updateBooksById(int bookId, Books book) throws BookNotFoundException {
		Optional<Books> optionalBook = LibraryRepository.findById(bookId);

		if (!optionalBook.isPresent()) {
			throw new BookNotFoundException("Book Not found in library Repository, provide the correct book id");
		}

		
		book.setId(bookId);
		return libraryRepository.save(book);

	}
	
}
