package com.neo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {

    @GetMapping("sayHello")
    public String sayHello(String name){
        return "你大爺的";
    }

}
