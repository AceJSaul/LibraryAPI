package com.acejsaul.ApiLibrary.controllers;

import com.acejsaul.ApiLibrary.entities.Author;
import com.acejsaul.ApiLibrary.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping
    public ResponseEntity<List<Author>> getAll(){
        return ResponseEntity.ok().body(authorService.findAllAuthor());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Author> getById(@PathVariable Integer id){
        Author author = authorService.findAuthorById(id);

        return ResponseEntity.ok().body(author);
    }
}
