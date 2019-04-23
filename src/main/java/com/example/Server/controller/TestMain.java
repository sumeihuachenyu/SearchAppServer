package com.example.Server.controller;

import com.example.Server.messages.config.AppConfig;
import com.example.Server.messages.lib.MESSAGEXsend;
import com.example.Server.messages.utils.ConfigLoader;
import com.example.Server.utils.Utils;


/**
 * Created by lenovo on 2019-03-09.
 * 调用发送短信工具
 */
public class TestMain {
//    public static void main(String[] args){
//        SendSmsResponse sendSmsResponse = null;
//        try {
//            sendSmsResponse = Utils.sendSms();
//            System.out.println("提示信息内容: " + sendSmsResponse.getMessage());
//            System.out.println("提示信息对应码: " + sendSmsResponse.getCode());
//        } catch(ClientException e){
//            e.printStackTrace();
//        }
//    }
    public static void main(String[] args) {
        //get方法
        AppConfig config = ConfigLoader.load(ConfigLoader.ConfigType.Message);
        MESSAGEXsend submail = new MESSAGEXsend(config);
        submail.addTo("18209571211");
        submail.setProject("ktxJU");
        String code = Utils.runNumber();
        submail.addVar("code", code);
        String time = Utils.getEndTime();
        submail.addVar("time", "30");
        //String response=submail.xsend();
        //System.out.println("接口返回数据："+response);
    }
}
