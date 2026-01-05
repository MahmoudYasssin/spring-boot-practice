package com.example.spring_boot_practice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @GetMapping("/")
    public String sayHello()
    {
        return "Hello I am a First Rest Controller";
    }

}
