package com.example.Server.controller;

import com.example.Server.entity.MessageWithBLOBs;
import com.example.Server.response.BaseResponse;
import com.example.Server.response.ConstResponse;
import com.example.Server.response.DataResponse;
import com.example.Server.service.MessageService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by lenovo on 2019-04-03.
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/message")
public class MessageController {
    @Resource
    private MessageService messageService;

    @RequestMapping("/getmessages")
    private BaseResponse getMessage(@RequestParam("userid") String userid){
        List<MessageWithBLOBs> messages = messageService.getMessage(userid);
        if(messages != null){
            return new DataResponse(messages, ConstResponse.DESC_OK, ConstResponse.STATUS_OK);
        }else{
            return new BaseResponse("暂无消息记录", ConstResponse.STATUS_PARAM_ERROR);
        }
    }
}
