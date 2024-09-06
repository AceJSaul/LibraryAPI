package com.acejsaul.ApiLibrary.services;

import com.acejsaul.ApiLibrary.entities.User;
import com.acejsaul.ApiLibrary.exceptions.ResourceNotFound;
import com.acejsaul.ApiLibrary.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(Integer id){
        try {
            Optional<User> user = userRepository.findById(id);
            return user.orElseThrow();
        }
        catch (NoSuchElementException e){
            throw new ResourceNotFound("User not found.");
        }
    }
}
