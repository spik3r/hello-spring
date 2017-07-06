package com.kaitait.hellospring.controllers;

import com.kaitait.hellospring.mail.DemoBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kai-tait on 6/07/2017.
 */
@RestController
public class SomeController
{
    
    @Autowired
    private DemoBean demoBean;
    
    @RequestMapping("/")
    @ResponseBody
    public String hello() {
        return demoBean.foo();
    }
}
