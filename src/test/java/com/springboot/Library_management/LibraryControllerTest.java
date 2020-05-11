package com.springboot.Library_management;


import static org.junit.Assert.assertNotNull;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import com.springboot.Library_management.library.Books;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LibraryApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LibraryControllerTest {
	
//	@Autowired
//    private TestRestTemplate restTemplate;
//	
//	@LocalServerPort
//    private int port;
//
//	private String getRootUrl() {
//        return "http://localhost:" + port;
//    }
//	@Test
//    public void testGetAllBooks() {
//    HttpHeaders headers = new HttpHeaders();
//       HttpEntity<String> entity = new HttpEntity<String>(null, headers);
//       ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/books",
//       HttpMethod.GET, entity, String.class);  
//       assertNotNull(response.getBody());
//   }
//	 @Test
//	    public void testGetBookById() {
//	        Books book = restTemplate.getForObject(getRootUrl() + "/books/19", Books.class);
//	        System.out.println(book.getBookname());
//	        assertNotNull(book);
//	    }
//	 @Test
//	    public void testaddBook() {
//	        Books book = new Books();
//	        book.setBookname("c++p");
//	        book.setAuthor("ajithk");
//	        book.setEdition(2);
//	        book.setDate("2020-04-15");
//	        book.setAmount(1323);
//	        ResponseEntity<Books> postResponse = restTemplate.postForEntity(getRootUrl() + "/books", book, Books.class);
//	        assertNotNull(postResponse);
//	        assertNotNull(postResponse.getBody());
//	    }
//	 @Test
//	    public void testUpdateBooks() {
//	        int bookId = 19;
//	        Books book = restTemplate.getForObject(getRootUrl() + "/books/" + bookId, Books.class);
//	        book.setBookname("admin1");
//	        book.setAuthor("admin2");
//	        restTemplate.put(getRootUrl() + "/books/" + bookId, book);
//	        Books updatedBook = restTemplate.getForObject(getRootUrl() + "/books/" + bookId, Books.class);
//	        assertNotNull(updatedBook);
//	    }
//	 @Test
//	    public void testDeleteBooks() {
//	         int bookId = 15;
//	         Books book = restTemplate.getForObject(getRootUrl() + "/books/" + bookId, Books.class);
//	         assertNotNull(book);
//	         restTemplate.delete(getRootUrl() + "/books/" + bookId);
//	         try {
//	              book = restTemplate.getForObject(getRootUrl() + "/books/" + bookId, Books.class);
//	         } catch (final HttpClientErrorException e) {
//	              assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
//	         }
//	    }
}
