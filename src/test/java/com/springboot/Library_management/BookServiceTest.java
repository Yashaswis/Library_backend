package com.springboot.Library_management;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.springboot.Library_management.library.Books;
import com.springboot.Library_management.library.LibraryRepository;
import com.springboot.Library_management.library.exception.BooksExistsException;
import com.springboot.Library_management.library.service.BookService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookServiceTest {

	@Autowired
	private BookService bookService;
	
	@MockBean
	private LibraryRepository libraryRepository;
	
	
	@Test
	public void testaddBooks() throws BooksExistsException {
		Books book = new Books();
		book.setBookId(1);
		book.setAuthor("charls babbage");
		book.setBookname("cpp");
		book.setEdition(2);
		book.setDate("jan");
		book.setAmount(2300);
		
		when(libraryRepository.save(book)).thenReturn(book);
		assertEquals(book, bookService.addBooks(book));
	}
	
	@Test
	public void testgetBooksById() {
		Books book = new Books();
		book.setBookId(1);
		book.setAuthor("charls babbage");
		book.setBookname("cpp");
		book.setEdition(2);
		book.setDate("jan");
		book.setAmount(2300);
		
		Mockito.when(libraryRepository.findById(1)).thenReturn(book);
	}
	
	@Test
	public void testgetAllBook() {
		Books book1 = new Books();
		book1.setBookId(1);
		book1.setAuthor("charls babbage");
		book1.setBookname("cpp");
		book1.setEdition(2);
		book1.setDate("jan");
		book1.setAmount(2300);
		
		Books book2 = new Books();
		book2.setBookId(2);
		book2.setAuthor("charls babbage");
		book2.setBookname("cpp");
		book2.setEdition(2);
		book2.setDate("jan");
		book2.setAmount(2300);
		
		List<Books> bookList = new ArrayList<>();
		bookList.add(book1);
		bookList.add(book2);
		
		when(libraryRepository.findAll()).thenReturn(bookList);
		assertEquals(bookService.getAllBooks(),bookList);
	}
	
	@Test
	public void testupdateBook() {
		Books book = new Books();
		book.setBookId(1);
		book.setAuthor("charls babbage");
		book.setBookname("cpp");
		book.setEdition(2);
		book.setDate("jan");
		book.setAmount(2300);
		
		when(libraryRepository.findById(1)).thenReturn(book);
		book.setBookname("c++");
		
		when(libraryRepository.save(book)).thenReturn(book);
		
		assertEquals(book,bookService.updateBooks(1, book));
	}
	
	@Test
	public void testdeletebook() {
		Books book = new Books();
		book.setBookId(1);
		book.setAuthor("charls babbage");
		book.setBookname("cpp");
		book.setEdition(2);
		book.setDate("jan");
		book.setAmount(2300);
		
		when(libraryRepository.findById(1)).thenReturn(book);
		
		when(libraryRepository.exists(book.getBookId())).thenReturn(false);
		
		assertFalse(libraryRepository.exists(book.getBookId()));
	}

	

}
















