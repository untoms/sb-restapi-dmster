package com.example.springbootrest.controller;

import com.example.springbootrest.enitities.User;
import com.example.springbootrest.exceptions.UserExistException;
import com.example.springbootrest.exceptions.UserNameNotFoundException;
import com.example.springbootrest.exceptions.UserNotFoundException;
import com.example.springbootrest.sevices.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Api(
        tags = "User Management",
        value = "UserSvcController"
)
@RestController
@Validated
@RequestMapping(value = "/users")
public class UserSvcController {

    final private UserService userService;

    final private PasswordEncoder encoder;

    @Autowired
    public UserSvcController(UserService userService,PasswordEncoder encoder) {
        this.userService = userService;
        this.encoder = encoder;
    }

    @GetMapping("/byusername/{username}")
    public User findByUsername(@PathVariable("username") String username) throws UserNameNotFoundException {
       User usr = userService.findByUsername(username);
       if (usr == null){
           throw new UserNameNotFoundException("Usename not found");
       }

       return usr;
    }

    @ApiOperation(value = "create new user")
    @PostMapping
    public ResponseEntity<Void> createUser(
            @ApiParam("User Information for a new user to be created.")
            @Valid @RequestBody User user, UriComponentsBuilder builder){
        try{
            User created = userService.createUser(user);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(builder.path("/users/{id}").buildAndExpand(created.getId()).toUri());
            return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
        }catch (UserExistException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }


    @GetMapping("/{id}")
    public Optional<User> findByUserId(@Min(1) @PathVariable("id") Long id){
        try {
            return userService.findByUserId(id);
        } catch (UserNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable("id") Long id){
        userService.deleteUserById(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable("id") Long id, @RequestBody User user){
        try {
            return userService.updateUserById(id, user);
        } catch (UserNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PutMapping("/username/{id}/{username}")
    public User updateUsername(@PathVariable("id") Long id, @PathVariable("username") String username){
        return userService.updateUsernameById(id, username);
    }

    @GetMapping("/ids/{ids}")
    public List<User> findByIds(@PathVariable("ids") String ids){

        String []strIds = ids.split(",");
        List<Long> idsLong = new ArrayList<>();
        for ( String s : strIds){
            idsLong.add(Long.parseLong(s));
        }

        return userService.findByIdIn(idsLong);

    }

    @GetMapping
    public List<User> findAll(){
        return userService.findAllUsers();

    }

    @PostMapping("/regis")
    public ResponseEntity<Void> regis(@Valid @RequestBody User user, UriComponentsBuilder builder){
        try{
            String plainPass = user.getPassword();
            user.setPassword(encoder.encode(plainPass.subSequence(0, plainPass.length())));
            User created = userService.createUser(user);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(builder.path("/users/{id}").buildAndExpand(created.getId()).toUri());
            return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
        }catch (UserExistException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
