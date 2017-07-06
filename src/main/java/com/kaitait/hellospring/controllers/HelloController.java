package com.kaitait.hellospring.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kai-tait on 6/07/2017.
 */
@RestController
public class HelloController {
    
    @Value("${app.name}")
    private String appName;
    
    @RequestMapping("/hello")
    public String hello() {
        return "Hello World! " + appName;
    }
}
