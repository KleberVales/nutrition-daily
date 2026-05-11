package com.nutritiondaily.userservice.controller;

import com.nutritiondaily.userservice.entity.User;
import com.nutritiondaily.userservice.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public String createUser(@RequestBody User user) {

        userService.saveUser(user);
        return "User saved successfully";
    }
}
