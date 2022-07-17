package com.startproject.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController       // return response body
public class HelloController {

    //@RequestMapping(name ="/",method = RequestMethod.GET)  we can use @GetMapping
    @GetMapping("/")
    public String Greeting(){
        return "Hello From Spring-Boot!";
    }

}
