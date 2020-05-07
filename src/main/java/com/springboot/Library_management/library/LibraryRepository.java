package com.springboot.Library_management.library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("libraryRepository")
public interface LibraryRepository extends JpaRepository<BooksRequestDto, Integer> 
{

}
