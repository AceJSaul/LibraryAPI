package com.acejsaul.ApiLibrary.services;

import com.acejsaul.ApiLibrary.entities.User;
import com.acejsaul.ApiLibrary.exceptions.ResourceNotFound;
import com.acejsaul.ApiLibrary.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(String id){
        try {
            Optional<User> user = userRepository.findById(id);
            return user.orElseThrow();
        }
        catch (NoSuchElementException e){
            throw new ResourceNotFound("User not found.");
        }
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByLogin(email);
    }
}
