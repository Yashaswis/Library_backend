package com.springboot.Library_management;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.Library_management.library.Books;
import com.springboot.Library_management.library.LibraryRepository;
@Service
public class BookService {
	@Autowired 
	LibraryRepository libraryRespository;
	public List<Books> getAllBooks()
	{  
		List<Books> books = new ArrayList<Books>();  
		libraryRespository.findAll().forEach(books1 -> books.add(books1));  
		return books;  
		} 
	public Books getBooksById(int id)   
	{  
	return libraryRespository.findById(id).get();  
	}  
	public void saveOrUpdate(Books books)   
	{  
		libraryRespository.save(books);  
	}
	public void delete(int id)   
	{  
		libraryRespository.deleteById(id);  
	}  
	//updating a record  
	public void update(Books books, int bookId)   
	{  
		libraryRespository.save(books);  
	}  
	
}
