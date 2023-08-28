package com.api.controller;

import com.api.model.roles.UserEntity;
import com.api.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public UserEntity createUsers(@RequestBody UserEntity userEntity){
        return service.createUser(userEntity);
    }
}
