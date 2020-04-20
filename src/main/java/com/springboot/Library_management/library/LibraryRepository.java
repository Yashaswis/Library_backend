package com.springboot.Library_management.library;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<Books, Integer> {


}
