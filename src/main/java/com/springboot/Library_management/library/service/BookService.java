package com.springboot.Library_management.library.service;
import java.util.List;
import java.util.Optional;

import com.springboot.Library_management.library.entity.Books;
import com.springboot.Library_management.library.exception.BooksExistsException;
import com.springboot.Library_management.library.exception.ResourceNotFoundException;

public interface BookService {

	public Books addBooks(Books book) throws BooksExistsException;

	public void deleteBooks(int bookId) throws ResourceNotFoundException;

	public Books getBooksbyId(int bookId) throws ResourceNotFoundException;
	
	public List<Books> getAllBooks();

	public Books updateBooks(int bookId, Books book) throws ResourceNotFoundException;

	

}
