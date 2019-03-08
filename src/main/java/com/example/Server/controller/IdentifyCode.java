package com.example.Server.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lenovo on 2019-03-08.
 */

@RestController
public class IdentifyCode {
    @RequestMapping(value="/getVerifyByMobile",method = RequestMethod.GET)
    public void getVerifyByMobile(@RequestParam("sign") String sign,@RequestParam("mobile") String mobile){
        System.out.print("成功进去了");
        System.out.print("sign="+sign+",mobile="+mobile);
         // return "sign="+sign+",mobile="+mobile;
    }
}