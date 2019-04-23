package com.example.Server.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lenovo on 2019-03-07.
 */
@Controller
public class HelloController {
    @RequestMapping("/test")
    private String index(){
        return "/index";
    }
}
