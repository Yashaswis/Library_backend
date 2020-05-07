package com.springboot.Library_management.library.service;
import java.util.List;
import java.util.Optional;
import com.springboot.Library_management.library.BooksRequestDto;

public interface BookService {

	public BooksRequestDto addBooks(BooksRequestDto book);

	public BooksRequestDto updateBooks(Integer bookId,BooksRequestDto book);

	public void deleteBooks(int bookId);

	public Optional<BooksRequestDto> getBooksbyId(Integer bookId);
	
	public List<BooksRequestDto> getAllBooks();
}
