package com.example.Server.controller;

import com.example.Server.entity.Type;
import com.example.Server.response.BaseResponse;
import com.example.Server.response.ConstResponse;
import com.example.Server.response.DataResponse;
import com.example.Server.service.TypeService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lenovo on 2019-04-09.
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/type")
public class TypeController {
    @Resource
    private TypeService typeService;

    @RequestMapping("/getTypes")
    private BaseResponse getTypes(@RequestParam("type") String type){
        List<Type> types= typeService.getTypes();
        System.out.println("类型数据="+types);
        if(types != null){
            return new DataResponse(types, ConstResponse.DESC_OK,ConstResponse.STATUS_OK);
        }else{
            return new BaseResponse("暂无分类",ConstResponse.STATUS_PARAM_ERROR);
        }
    }
}
