package com.example.userauth.service;

import com.example.userauth.entity.User;
import com.example.userauth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
      
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("this email currerntly working now!");
        }
        
        return userRepository.save(user);
    }
}