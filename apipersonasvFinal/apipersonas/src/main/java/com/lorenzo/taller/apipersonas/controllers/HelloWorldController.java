package com.lorenzo.taller.apipersonas.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class HelloWorldController {

    // GET /helloWorld -> Hello world
    @GetMapping("/helloWorld")
    public String helloWorld() {
        return "Hello world";
    }
    

}
