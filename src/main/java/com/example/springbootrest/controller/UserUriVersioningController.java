package com.example.springbootrest.controller;

import com.example.springbootrest.enitities.User;
import com.example.springbootrest.dtos.UserDtoV1;
import com.example.springbootrest.dtos.UserDtoV2;
import com.example.springbootrest.exceptions.UserNotFoundException;
import com.example.springbootrest.sevices.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;
import java.util.Optional;

@RestController
@Validated
@RequestMapping(value = "/versioning/uri/users")
public class UserUriVersioningController {

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping({"/v1.0/{id}", "/v1.1/{id}"})
    public UserDtoV1 getByUerId(@PathVariable("id") @Min(1) Long id) throws UserNotFoundException {

        Optional<User> usrOpt = userService.findByUserId(id);

        User user = usrOpt.get();

        return  modelMapper.map(user, UserDtoV1.class);
    }

    @GetMapping("/v2.0/{id}")
    public UserDtoV2 getByUerIdV2(@PathVariable("id") @Min(1) Long id) throws UserNotFoundException {

        Optional<User> usrOpt = userService.findByUserId(id);

        User user = usrOpt.get();

        return  modelMapper.map(user, UserDtoV2.class);
    }



}
