package com.springboot.Library_management;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.springboot.Library_management.library.entity.Books;
import com.springboot.Library_management.library.exception.BooksExistsException;
import com.springboot.Library_management.library.exception.ResourceNotFoundException;
import com.springboot.Library_management.library.repo.LibraryRepository;
import com.springboot.Library_management.library.service.BookService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookServiceTest {

	@Autowired
	private BookService bookService;
	
	@MockBean
	private LibraryRepository libraryRepository;
	
	Books book = new Books();
	
	@Before
	public void init() {
		book.setBookId(1);
		book.setAuthor("charls babbage");
		book.setBookname("cpp");
		book.setEdition(2);
		book.setDate("jan");
		book.setAmount(2300);
	}
	
	@Test
	public void testaddBooks() throws BooksExistsException {
		
		when(libraryRepository.save(book)).thenReturn(book);
		assertEquals(book, bookService.addBooks(book));
	}
	
	@Test
	public void testgetBooksById() throws ResourceNotFoundException {
		
		Mockito.when(libraryRepository.findById(1)).thenReturn(Optional.of(book));
		assertThat(bookService.getBooksbyId(1)).isEqualTo(book);
	}
	
	@Test
	public void testgetAllBook() {
		Books book1 = new Books(2,"bookname","author","2020-04-20",5,200);
		Books book2 = new Books(3,"bookname1","author2","2020-04-20",2,800);
		List<Books> bookList = new ArrayList<>();
		bookList.add(book1);
		bookList.add(book2);
		
		when(libraryRepository.findAll()).thenReturn(bookList);
		assertEquals(bookService.getAllBooks(),bookList);
	}
	
	@Test
	public void testupdateBook() throws ResourceNotFoundException {
		
		when(libraryRepository.findById(1)).thenReturn(Optional.of(book));
		book.setBookname("c++");
		
		when(libraryRepository.save(book)).thenReturn(book);
		
		assertEquals(book,bookService.updateBooks(1, book));
	}
	
	@Test
	public void testdeletebook() throws ResourceNotFoundException {
		
		when(libraryRepository.findById(1)).thenReturn(Optional.of(book));
		
		when(libraryRepository.existsById(book.getBookId())).thenReturn(false);
		
		assertFalse(libraryRepository.existsById(book.getBookId()));
	}

	

}
















