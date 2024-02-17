package com.example.ewalletuserservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import jakarta.validation.Valid;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/user")
    public User createUser(@Valid @RequestBody UserCreateRequest userCreateRequest) throws JsonProcessingException  {
        return userService.create(userCreateRequest.to());
        
    }

    @GetMapping("/user")
    public User getUser(@RequestParam("id") int id){
        return userService.get(id);
    }

    
    
}