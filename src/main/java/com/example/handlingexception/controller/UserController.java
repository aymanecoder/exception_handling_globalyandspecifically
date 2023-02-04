package com.example.handlingexception.controller;


import com.example.handlingexception.entity.User;
import com.example.handlingexception.error.ApiException;
import com.example.handlingexception.error.NotFoundException;
import com.example.handlingexception.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable("id") Long userId) {
        return userRepository.findById(userId).orElseThrow(()->new NotFoundException("Could not find user" + userId));
        /*
        * you can handle exceptions globally by throwing Exception
        * */

    }
    @PostMapping("/users/save")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/users").toUriString());
        return ResponseEntity.created(uri).body(userRepository.save(user));

    }
}
