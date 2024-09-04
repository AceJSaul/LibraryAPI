package com.acejsaul.ApiLibrary.services;

import com.acejsaul.ApiLibrary.entities.Author;
import com.acejsaul.ApiLibrary.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public Author findAuthorById(Integer id){
        Optional<Author> optionalAuthor = authorRepository.findById(id);
        return optionalAuthor.orElse(null);
    }

    public List<Author> findAllAuthor(){
        return authorRepository.findAll();
    }
}
