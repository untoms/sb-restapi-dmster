package com.example.springbootrest.controller;

import com.example.springbootrest.dtos.UserMmDto;
import com.example.springbootrest.enitities.User;
import com.example.springbootrest.exceptions.UserNotFoundException;
import com.example.springbootrest.sevices.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.Option;
import javax.validation.constraints.Min;
import java.util.Optional;

@RestController
@Validated
@RequestMapping(value = "/modelmapper/users")
public class UserModelMapperController {

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/{id}")
    public UserMmDto getUserById(@PathVariable("id") @Min(1) Long id) throws UserNotFoundException {

        Optional<User> userOpt = userService.findByUserId(id);

        User user = userOpt.get();

        UserMmDto result = modelMapper.map(user, UserMmDto.class);

        return result;


    }

}
