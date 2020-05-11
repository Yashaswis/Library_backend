package com.springboot.Library_management.library.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.Library_management.library.Books;
import com.springboot.Library_management.library.LibraryRepository;
import com.springboot.Library_management.library.exception.BooksExistsException;
import com.springboot.Library_management.library.exception.ResourceNotFoundException;

@Service("bookService")
public class BookServiceImpl implements BookService {
	@Autowired
	private LibraryRepository libraryRepository;
//	BooksRequestDto book = new BooksRequestDto();
//	Books bookEntity = new Books();
//	BeanUtils.copyProperties(bookEntity, book);
	@Override
	public Books addBooks(Books book)throws BooksExistsException {
		Books existingBooks = libraryRepository.findByBookname(book.getBookname());
		if(existingBooks != null) {
			throw new BooksExistsException("Book already exists in repository");
		}
		return libraryRepository.save(book);
	}

	@Override
	public Books updateBooks(int bookId , Books book)throws ResourceNotFoundException {
		Optional<Books> books = libraryRepository.findById(bookId);
		if(books.isPresent()) {
			return libraryRepository.save(book);
		}
		else {
			throw new ResourceNotFoundException("No book record exist for given id");
		}
	}

	@Override
	public Books getBooksbyId(int bookId) throws ResourceNotFoundException {
		Optional<Books> book = libraryRepository.findById(bookId);
		if(book.isPresent()) {
			return book.get();
		}
		else {
			throw new ResourceNotFoundException("No book record exist for given id");
		}
		
	}

	@Override
	public List<Books> getAllBooks() {
		List<Books> list = libraryRepository.findAll();
		if(list.size()>0) {
			return list;
		}
		else {
		return new ArrayList<Books>();
		}
	}

	@Override
	public void deleteBooks(int bookId) throws ResourceNotFoundException{
		Optional<Books> book = libraryRepository.findById(bookId);
		if(book.isPresent()) {
			libraryRepository.deleteById(bookId);
		}
		else {
			throw new ResourceNotFoundException("No book record exist for given id");
		}
	}

}
