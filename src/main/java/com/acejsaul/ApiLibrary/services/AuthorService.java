package com.acejsaul.ApiLibrary.services;

import com.acejsaul.ApiLibrary.entities.Author;
import com.acejsaul.ApiLibrary.exceptions.ResourceNotFound;
import com.acejsaul.ApiLibrary.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public Author findAuthorById(Integer id){
       try {
           Optional<Author> optionalAuthor = authorRepository.findById(id);
           return optionalAuthor.orElseThrow();
       }
       catch (NoSuchElementException e){
           throw new ResourceNotFound("Author not found!");
       }
    }

    public List<Author> findAllAuthor(){
        return authorRepository.findAll();
    }
}
