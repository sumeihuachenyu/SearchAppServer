package com.example.Server.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lenovo on 2019-03-07.
 */
@RestController
@EnableAutoConfiguration
public class HelloController {
    @RequestMapping("/success/hello")
    private String index(){
        return "Hello World!";
    }
}
