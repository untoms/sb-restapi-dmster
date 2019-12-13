package com.example.springbootrest.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
public class UserController {

    @Autowired
    private ResourceBundleMessageSource messageSource;

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

    @GetMapping("/hello-int")
    public String getMessageInI18NFormat(
            @RequestHeader(name = "Accept-Language", required = true) String label){
        return messageSource.getMessage("label.hello",null, new Locale(label));
    }

    @GetMapping("/hello-int2")
    public String getMessageInI18NFormatLocal(){
        return messageSource.getMessage("label.hello",null, LocaleContextHolder.getLocale());
    }



}
