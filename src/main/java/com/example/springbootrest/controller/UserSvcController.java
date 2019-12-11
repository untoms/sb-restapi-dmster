package com.example.springbootrest.controller;

import com.example.springbootrest.enitities.User;
import com.example.springbootrest.sevices.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class UserSvcController {

    final private UserService userService;

    @Autowired
    public UserSvcController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/byusername/{username}")
    public User findByUsername(@PathVariable("username") String username){
       return userService.findByUsername(username);
    }

    @PostMapping("/createuser")
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping("/users/{id}")
    public Optional<User> findByUserId(@PathVariable("id") Long id){
        return userService.findByUserId(id);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUserById(@PathVariable("id") Long id){
        userService.deleteUserById(id);
    }

    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable("id") Long id, @RequestBody User user){
        return userService.updateUserById(id, user);
    }

    @PutMapping("/users/username/{id}/{username}")
    public User updateUsername(@PathVariable("id") Long id, @PathVariable("username") String username){
        return userService.updateUsernameById(id, username);
    }

    @GetMapping("/users/ids/{ids}")
    public List<User> findByIds(@PathVariable("ids") String ids){

        String []strIds = ids.split(",");
        List<Long> idsLong = new ArrayList<>();
        for ( String s : strIds){
            idsLong.add(Long.parseLong(s));
        }

        return userService.findByIdIn(idsLong);

    }
}
