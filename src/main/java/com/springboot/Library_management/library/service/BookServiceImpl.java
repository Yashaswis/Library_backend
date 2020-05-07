package com.springboot.Library_management.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.Library_management.library.BooksRequestDto;
import com.springboot.Library_management.library.LibraryRepository;

@Service("bookService")
public class BookServiceImpl implements BookService {
	@Autowired
	private LibraryRepository libraryRepository;
	
	
	@Override
	public BooksRequestDto addBooks(BooksRequestDto book) {
		// TODO Auto-generated method stub
		return libraryRepository.save(book);
	}

	@Override
	public BooksRequestDto updateBooks(Integer bookId , BooksRequestDto book) {
		// TODO Auto-generated method stub
		return libraryRepository.save(book);
	}

	@Override
	public Optional<BooksRequestDto> getBooksbyId(Integer bookId) {
		// TODO Auto-generated method stub
		return libraryRepository.findById(bookId);
	}

	@Override
	public List<BooksRequestDto> getAllBooks() {
		// TODO Auto-generated method stub
		return (List<BooksRequestDto>) libraryRepository.findAll();
	}

	@Override
	public void deleteBooks(int bookId) {
		// TODO Auto-generated method stub
		libraryRepository.deleteById(bookId);
	}

}
