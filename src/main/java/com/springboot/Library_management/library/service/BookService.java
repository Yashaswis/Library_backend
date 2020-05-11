package com.springboot.Library_management.library.service;
import java.util.List;
import com.springboot.Library_management.library.Books;
import com.springboot.Library_management.library.exception.ResourceNotFoundException;

public interface BookService {

	public Books addBooks(Books book);

	public void deleteBooks(int bookId) throws ResourceNotFoundException;

	public Books getBooksbyId(int bookId) throws ResourceNotFoundException;
	
	public List<Books> getAllBooks();

	public Books updateBooks(int bookId, Books book) throws ResourceNotFoundException;

}
