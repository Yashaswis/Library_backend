package com.springboot.Library_management.library;


import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("libraryRepository")
public interface LibraryRepository extends JpaRepository<Books, Integer> 
{

	Books findByBookname(String bookname);

	




	
	
}
