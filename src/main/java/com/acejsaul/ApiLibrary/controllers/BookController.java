package com.acejsaul.ApiLibrary.controllers;

import com.acejsaul.ApiLibrary.entities.Author;
import com.acejsaul.ApiLibrary.entities.Book;
import com.acejsaul.ApiLibrary.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> findAll(){
        List<Book> books = bookService.findAll();
        return ResponseEntity.ok().body(books);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Book> findById(@PathVariable Integer id){
        return ResponseEntity.ok().body(bookService.findById(id));
    }

    @GetMapping(value = "/{id}/author")
    public ResponseEntity<Author> findAuthor(@PathVariable Integer id){
        return ResponseEntity.ok().body(bookService.findAuthor(id));
    }

    @GetMapping(value = "/{id}/imageUrl")
    public ResponseEntity<String> getImageUrl(@PathVariable Integer id){
        return ResponseEntity.ok().body(bookService.getImageUrl(id));
    }
}
