package com.springboot.Library_management;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.springboot.Library_management.library.Books;
import com.springboot.Library_management.library.LibraryRepository;
import com.springboot.Library_management.library.exception.BooksExistsException;
import com.springboot.Library_management.library.exception.ResourceNotFoundException;
import com.springboot.Library_management.library.service.BookService;
@SuppressWarnings("deprecation")
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class LibraryApplicationTests {
	
	@Autowired
	private BookService bookService;
	
	@MockBean
	private LibraryRepository libraryRepository;
	

	@Test
	public void getAllBooksTest() {
		when(libraryRepository.findAll()).thenReturn(Stream.of(new Books(2,"bookname","author","2020-04-20",5,200),new Books(3,"bookname1","author2","2020-04-20",2,800))
				.collect(Collectors.toList()));
		assertEquals(2,bookService.getAllBooks().size());
	}
	
	@Test
	public void addBooksTest() throws BooksExistsException {
		Books book= new Books(4,"bookname3","author3","2020-04-20",3,1000);
		when(libraryRepository.save(book)).thenReturn(book);
		assertEquals(book, bookService.addBooks(book));
		
	}
	
//	@Test
//	public void updateBooksTest() throws ResourceNotFoundException {
//		Books book= new Books(4,"bookname3","author3","2020-04-20",3,1000);
//		when(libraryRepository.save(book)).thenReturn(book);
//		book.setBookname("book");
//		assertEquals(book,bookService.updateBooks(4,book));
//	}

//		@Test
//		public void deleteBookTest() throws ResourceNotFoundException {
//			Books book= new Books(4,"bookname3","author3","2020-04-20",3,1000);
//			bookService.deleteBooks(4);
//			verify(libraryRepository, times(1)).delete(book);
//			
//		}
	
	
}
