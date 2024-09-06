package com.acejsaul.ApiLibrary.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Year;
import java.util.*;

@Entity
@Table(name="books")
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String book_title;
    private String description;
    private Year release_year;
    @JsonIgnore
    private String image_url;

    @ManyToOne
    @JoinColumn(name = "author_id")
    @JsonIgnore
    private Author author;

    @ManyToMany(mappedBy = "favBooks")
    @JsonIgnore
    private Set<User> markedAsFavorite = new HashSet<>();

    public Book() {
    }

    public Book(Integer id, String book_title, String description, Year release_year, Author author, String imageUrl) {
        this.id = id;
        this.book_title = book_title;
        this.description = description;
        this.release_year = release_year;
        this.author = author;
        this.image_url = imageUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBook_title() {
        return book_title;
    }

    public void setBook_title(String book_title) {
        this.book_title = book_title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Year getRelease_year() {
        return release_year;
    }

    public void setRelease_year(Year release_year) {
        this.release_year = release_year;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author);
    }
}
