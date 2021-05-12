package edu.spring.security.authorize.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class HelloRestController {

    @GetMapping("user")
    public String helloUser(){
        return "Hello User";
    }

    @GetMapping("admin")
    public String helloAdmin(){
        return "Hello Admin";
    }
}
