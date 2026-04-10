package com.library.bookrental.controller;

import com.library.bookrental.model.User;
import com.library.bookrental.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>>getUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping
    public  ResponseEntity<User> addUser(@RequestBody User user) {
        return ResponseEntity.status(201).body(userService.saveUser(user));
    }
}
