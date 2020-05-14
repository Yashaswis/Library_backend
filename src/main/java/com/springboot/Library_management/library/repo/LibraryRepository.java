package com.springboot.Library_management.library.repo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.Library_management.library.entity.Books;

@Repository("libraryRepository")
public interface LibraryRepository extends CrudRepository<Books, Integer> 
{

	Books findByBookname(String bookname);	
}
