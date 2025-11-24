package com.user_service.user_service.controller;

import com.user_service.user_service.entity.User;
import com.user_service.user_service.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    @Autowired private UserRepository repo;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        user.setPassword("{noop}" + user.getPassword()); // later JWT
        return repo.save(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return repo.findAll();
    }
}
