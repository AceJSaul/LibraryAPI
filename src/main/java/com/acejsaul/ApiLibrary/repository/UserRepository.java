package com.acejsaul.ApiLibrary.repository;

import com.acejsaul.ApiLibrary.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    UserDetails findByLogin(String email);
}
