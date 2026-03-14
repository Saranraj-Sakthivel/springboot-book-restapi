package com.example.spring_set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class welcome {
    @GetMapping("/")
    public String come(){
        return "welcome to Spring world";
    }
    @GetMapping("/saran")
    public String helloworld(){
        return "Hello World";

    }
}
