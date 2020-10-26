package com.Spacex.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  //默认返回的所有结构都是json对象
public class HelloContorller {

    @GetMapping("/hello")
    public Object hello(){
        return "hello world";
    }

}
