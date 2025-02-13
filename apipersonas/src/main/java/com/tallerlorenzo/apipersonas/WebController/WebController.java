package com.tallerlorenzo.apipersonas.WebController;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/api")
@RestController
public class WebController {

    //GET  /helloWorld -> "Hello World"
    @GetMapping("/helloWorld")
    public String getMethodName() {
        return "Hello World";

    }
    

    
}
