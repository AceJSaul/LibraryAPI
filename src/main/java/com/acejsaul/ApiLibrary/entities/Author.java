package com.acejsaul.ApiLibrary.entities;

import com.acejsaul.ApiLibrary.exceptions.BadRequest;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "authors")
public class Author implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String first_name;
    private String last_name;

    @OneToMany(mappedBy = "author")
    private List<Book> books = new ArrayList<>();

    public Author() {
    }

    public Author(Integer id, String first_name, String last_name) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void addBook(Book book){
        if (!books.contains(book)){
            books.add(book);
        }
        else{
            throw new BadRequest("Book already in author's list");
        }
    }

    public Book removeBook(Book book){
        if (!books.contains(book)){
            throw new BadRequest("Book not in author's list");
        }
        else{
            books.remove(book);
            return book;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(id, author.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
