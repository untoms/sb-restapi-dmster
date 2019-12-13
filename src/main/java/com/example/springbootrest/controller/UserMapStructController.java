package com.example.springbootrest.controller;

import com.example.springbootrest.dtos.UserMsDto;
import com.example.springbootrest.enitities.User;
import com.example.springbootrest.exceptions.UserNotFoundException;
import com.example.springbootrest.mapper.UserMapper;
import com.example.springbootrest.repositories.UserReporisotry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@Validated
@RequestMapping(value = "/mapsruct/users")
public class UserMapStructController {

    @Autowired
    private UserReporisotry userReporisotry;

    @Autowired
    private UserMapper userMapper;

    @GetMapping
    public List<UserMsDto> getAll(){
        return userMapper.usersToUserDtos(userReporisotry.findAll());
    }

    @GetMapping("/{id}")
    public UserMsDto getUserById(@PathVariable Long id)throws UserNotFoundException{

        Optional<User> userOpt = userReporisotry.findById(id);
        if (!userOpt.isPresent())
            throw new UserNotFoundException("user not found");

        User u = userOpt.get();

        return userMapper.userToUserMsDto(u);
    }

}
