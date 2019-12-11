package com.example.springbootrest.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping(method = RequestMethod.GET, path = "/hello")
    public String helloWorld(){
        return "Hello world!";
    }

    @GetMapping("/hello-user")
    public UserDetails helloUser(){
//        return new UserDetails("digi","master","Jakarta");

        UserDetails u = new UserDetails();
        u.setCity("Jakarta");
        u.setFirstName("Digi");
        u.setLastName("Master");

        return u;
    }

}
