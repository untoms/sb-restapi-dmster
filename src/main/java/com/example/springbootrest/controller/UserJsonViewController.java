package com.example.springbootrest.controller;

import com.example.springbootrest.enitities.User;
import com.example.springbootrest.enitities.Views;
import com.example.springbootrest.exceptions.UserNotFoundException;
import com.example.springbootrest.sevices.UserService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.Min;
import java.util.Optional;

@RestController
@Validated
@RequestMapping(value = "/jsonview/users")
public class UserJsonViewController {

    @Autowired
    private UserService userService;

    @JsonView(Views.External.class)
    @GetMapping("/external/{id}")
    public Optional<User> getUserByIdExternal(@PathVariable("id") @Min(1) Long id){
        try {
            return userService.findByUserId(id);
        } catch (UserNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @JsonView(Views.Internal.class)
    @GetMapping("/internal/{id}")
    public Optional<User> getUserByIdInternal(@PathVariable("id") @Min(1) Long id){
        try {
            return userService.findByUserId(id);
        } catch (UserNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }


}
