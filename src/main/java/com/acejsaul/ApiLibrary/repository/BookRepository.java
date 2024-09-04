package com.acejsaul.ApiLibrary.repository;

import com.acejsaul.ApiLibrary.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
