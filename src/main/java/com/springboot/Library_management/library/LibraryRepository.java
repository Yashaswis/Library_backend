package com.springboot.Library_management.library;
import org.springframework.data.repository.CrudRepository;

public interface LibraryRepository extends CrudRepository<Books, Integer> {


}
