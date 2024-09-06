package com.acejsaul.ApiLibrary.entities;

import com.acejsaul.ApiLibrary.entities.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "users")
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class User implements Serializable, UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String first_name;
    private String last_name;
    // Spring Security
    private String login;
    private String password;
    private UserRole role;

    @ManyToMany
    @JoinTable(name = "favorite_books", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "book_id"))
    private final Set<Book> favBooks = new HashSet<>();

    public User(String first_name, String last_name, String email, String password, UserRole role) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.login = email;
        this.password = password;
        this.role = role;
    }


    // Add to fav

    public void addToFav(Book book){
        favBooks.add(book);
    }

    public Book removeFromFav(Book book) {
        if(favBooks.contains(book)){
            favBooks.remove(book);
            return book;
        }
        else{
            return null;
        }
    }
    // Getters


    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public void setEmail(String email) {
        this.login = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public Set<Book> getFavBooks() {
        return favBooks;
    }

    // Spring Security
    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == UserRole.ADMIN) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        else{
            return List.of(new SimpleGrantedAuthority("ROLE_USER"));
        }
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }
}
