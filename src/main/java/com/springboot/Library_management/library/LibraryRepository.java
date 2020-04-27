package com.springboot.Library_management.library;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LibraryRepository extends CrudRepository<Books, Integer> 
{

	Books findByBookname(String bookname);

}
