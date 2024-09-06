package com.acejsaul.ApiLibrary.services;

import com.acejsaul.ApiLibrary.entities.Author;
import com.acejsaul.ApiLibrary.entities.Book;
import com.acejsaul.ApiLibrary.exceptions.BadRequest;
import com.acejsaul.ApiLibrary.exceptions.ResourceNotFound;
import com.acejsaul.ApiLibrary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    public Book findById(Integer id){
        try{
            Optional<Book> optionalBook = bookRepository.findById(id);
            return optionalBook.orElseThrow();
        }
        catch (NoSuchElementException e){
            throw new ResourceNotFound("Book not found!");
        }
    }

    public Author findAuthor(Integer id){
        return findById(id).getAuthor();
    }

    public String getImageUrl(Integer id){
        return findById(id).getImage_url();
    }
}
