package com.nutritiondaily.userservice.service;

import com.nutritiondaily.userservice.entity.User;
import com.nutritiondaily.userservice.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    private UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String saveUser(User user) {
        userRepository.save(user);

        return "User saved successfully";
    }
}
