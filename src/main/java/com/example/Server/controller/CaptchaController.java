package com.example.Server.controller;

import com.example.Server.entity.Captcha;
import com.example.Server.messages.config.AppConfig;
import com.example.Server.messages.lib.MESSAGEXsend;
import com.example.Server.messages.utils.ConfigLoader;
import com.example.Server.response.BaseResponse;
import com.example.Server.response.ConstResponse;
import com.example.Server.response.DataResponse;
import com.example.Server.service.CaptchaService;
import com.example.Server.utils.Utils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by lenovo on 2019-03-10.
 */
@RestController
public class CaptchaController {
    @Resource
    private CaptchaService captchaService;

    @RequestMapping(value="/getVerifyByMobiles",method = RequestMethod.GET)
    public BaseResponse getVerifyByMobile(@RequestParam("sign") String sign, @RequestParam("mobile") String mobile) {
        //验证是否进入该action中
        System.out.print("成功进去了");
        System.out.print("sign=" + sign + ",mobile=" + mobile);
        //获取验证码和最终时间
        String code = Utils.runNumber();
        String time = Utils.getEndTime();

        if (!mobile.isEmpty()) {
            if (captchaService.isHave(mobile)) {
                //表示数据库中存在该手机号
                //需要在获取验证码之后将数据修改到数据库中

                //获取数据库中的数据
                Captcha captcha = captchaService.selectCaptcha(mobile);
                //获取到最终时间，如果超出当前时间，需要进行修改，如果没有超出，需要将数据库中的数据再次发送

                if (Utils.compareTime(captcha.getEndtime())) {
                    //最终时间小于当前时间，超出时间，需要进行修改，再次发送
                    captcha.setCaptcha(code);
                    captcha.setEndtime(time);
                    captcha.setPhone(mobile);

                    if (captchaService.updateCaptcha(captcha)) {
                        //进行短信发送数据的获取
//                        AppConfig config = ConfigLoader.load(ConfigLoader.ConfigType.Message);
//                        MESSAGEXsend submail = new MESSAGEXsend(config);
//                        submail.addTo(mobile);
//                        submail.setProject("ktxJU");
//                        submail.addVar("code", code);
//                        submail.addVar("time", "30");

                        //进行数据的验证
//                        System.out.println("发送的短信信息：");
//                        System.out.println("验证码：" + code);
//                        System.out.println("结束时间："+time);
//
//                        String response=submail.xsend();
//                        System.out.println("接口返回数据："+response);

                        //需要将修改后的数据发送给客户端
                        return new DataResponse(captcha, ConstResponse.DESC_OK, ConstResponse.STATUS_OK);
                    } else {
                        System.out.print("验证码修改失败");
                        return new BaseResponse("网络错误，请重新输入手机号", ConstResponse.STATUS_PARAM_ERROR);
                    }
                } else {
                    //最终时间大于当前时间，将数据库的数据取出重新发送一遍
//                    AppConfig config = ConfigLoader.load(ConfigLoader.ConfigType.Message);
//                    MESSAGEXsend submail = new MESSAGEXsend(config);
//                    submail.addTo(mobile);
//                    submail.setProject("ktxJU");
//                    submail.addVar("code", captcha.getCaptcha());
//                    submail.addVar("time", "30");

                    //进行数据的验证
//                    System.out.println("发送的短信信息：");
//                    System.out.println("验证码：" + captcha.getCaptcha());
//                    System.out.println("结束时间："+captcha.getEndtime());
//
//                    String response=submail.xsend();
//                    System.out.println("接口返回数据："+response);

                    //将数据库中的数据重新发送给客户端
                    return new DataResponse(captcha, ConstResponse.DESC_OK, ConstResponse.STATUS_OK);
                }
            } else {
                //表示数据中不存在该手机号
                //需要在获取验证码之后将数据插入到数据库

                //对验证码信息进行封装
                Captcha captcha = new Captcha(code, mobile, time);

                //插入数据
                if (captchaService.insertCaptcha(captcha)) {
                    //进行短信发送数据的获取
//                    AppConfig config = ConfigLoader.load(ConfigLoader.ConfigType.Message);
//                    MESSAGEXsend submail = new MESSAGEXsend(config);
//                    submail.addTo(mobile);
//                    submail.setProject("ktxJU");
//                    submail.addVar("code", code);
//                    submail.addVar("time", "30");
//
//                    //进行数据的验证
//                    System.out.println("发送的短信信息：");
//                    System.out.println("验证码：" + code);
//                    System.out.println("结束时间："+time);
//
//                    String response=submail.xsend();
//                    System.out.println("接口返回数据："+response);

                    //将新插入的数据发送给客户端
                    return new DataResponse(captcha, ConstResponse.DESC_OK, ConstResponse.STATUS_OK);
                } else {
                    System.out.print("验证码插入失败");
                    return new BaseResponse("网络错误，请重新输入手机号", ConstResponse.STATUS_PARAM_ERROR);
                }
            }
        }

        //需要去获得验证码
        // return "sign="+sign+",mobile="+mobile;
        return new BaseResponse("网络错误，请重新输入手机号", ConstResponse.STATUS_PARAM_ERROR);
    }

    @RequestMapping(value="/VerifyCompare",method = RequestMethod.GET)
    public BaseResponse VerifyCompare(@RequestParam("sign") String sign, @RequestParam("verify") String verify,@RequestParam("mobile") String mobile) {
        //验证是否进入该action中
        System.out.print("成功进去了");
        System.out.print("sign=" + sign + ",verify=" + verify+",mobile="+mobile);

        //获取验证码和最终时间
//        String code = Utils.runNumber();
//        String time = Utils.getEndTime();

        if (!verify.isEmpty()) {
            //1.首先查询有该手机号的那条数据：条件：不能过期 && 验证码必须完全相同
            if (captchaService.isHave(mobile)) {
                //表示数据库中存在该手机号

                //获取数据库中的数据
                Captcha captcha = captchaService.selectCaptcha(mobile);
                //获取到最终时间，如果超出当前时间，需要进行修改，如果没有超出，需要将数据库中的数据再次发送

                //验证时间是否过期
                if (Utils.compareTime(captcha.getEndtime())) {
                    //最终时间小于当前时间，超出时间，需要提示验证码已经失效，需要重新发送
                    System.out.print("验证码修改失败");
                    return new BaseResponse("此验证码已失效，请重新输入手机号获取验证码", ConstResponse.STATUS_PARAM_ERROR);

                } else {
                    //最终时间大于当前时间，将进行验证码的比较
                    //进行数据的验证
                    if(verify.equals(captcha.getCaptcha())){
                        return new BaseResponse("验证成功请修改密码", ConstResponse.STATUS_OK);
                    }else{
                        return new BaseResponse("此验证码已无效，请重新输入手机号获取", ConstResponse.STATUS_PARAM_ERROR);
                    }
                }
            } else {
                //表示数据中不存在该手机号
                    System.out.print("验证码插入失败");
                    return new BaseResponse("此验证码已失效，请重新输入手机号获取验证码", ConstResponse.STATUS_PARAM_ERROR);
            }
        }

        //需要去获得验证码
        // return "sign="+sign+",mobile="+mobile;
        return new BaseResponse("网络错误，请重新输入手机号", ConstResponse.STATUS_PARAM_ERROR);
    }

}
