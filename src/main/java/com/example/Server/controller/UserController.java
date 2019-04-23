package com.example.Server.controller;
import com.example.Server.entity.MessageWithBLOBs;
import com.example.Server.entity.User;
import com.example.Server.response.BaseResponse;
import com.example.Server.response.ConstResponse;
import com.example.Server.response.DataResponse;
import com.example.Server.service.MessageService;
import com.example.Server.service.UserService;
import com.example.Server.token.TokenUtils;
import com.example.Server.utils.Utils;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by lenovo on 2019-03-31.
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/user")
public class UserController {
    public static final String TOKEN_OK = "ok"; //检测成功
    @Resource
    private UserService userService;
    @Resource
    private MessageService messageService;

    @RequestMapping("/login")
    private BaseResponse login(@RequestParam("password") String password, @RequestParam("mobile") String mobile, @RequestParam("token") String token) {
        //验证是否进入该action
        System.out.println("登录成功进去了");
        System.out.println("password=" + password + ",mobile=" + mobile+",token="+token);

        if("无值".equals(token) && !"wuzhi".equals(password) && !"wuzhi".equals(mobile) ){
            System.out.println("1.登录成功进去了");
            //表示是第一次登录，则需要将用户查询出来，并创建token
            //还有一种情况是用户的token过期，需要进行登录，那么password和mobile不为空这两种情况
            //根据密码和手机号查询用户
            User queryUser = userService.findUserByPhoneAndPassword(mobile,password);
            if(queryUser != null){
                Integer userid = queryUser.getUserid();
                String tokenTmp = TokenUtils.getToken(userid.toString());//根据userid重新生成的
                User user = new User(userid,queryUser.getPhone(),queryUser.getUsername(),queryUser.getPassword(),tokenTmp,queryUser.getHeadaddress());
                if(userService.updateUserById(user)){
                    //修改成功
                    return new DataResponse(user,ConstResponse.DESC_OK,ConstResponse.STATUS_OK);
                }
            }
            return new BaseResponse("手机号或密码错误",ConstResponse.STATUS_PARAM_ERROR);
        }else{
            System.out.println("2.登录成功进去了");
            //表示不是第一次进行登录，需要检测token的时间戳和正确性
            //首先从token中获取userid
            String userid = TokenUtils.getQueryUserid(token);
            //需要从数据库中获取token
            User user = userService.findUserByUserid(userid);
            String result = TokenUtils.checkToken(token,user.getToken());
            System.out.println("checkToken Result: " + result);
            //检测成功
            if(result.equals(TOKEN_OK)) {
                System.out.println("==>token verification succeeded!");
                //可以直接通过token进行登录，不用进入登录页面
                return new DataResponse(user,ConstResponse.DESC_OK,ConstResponse.STATUS_OK);
            }else{
                //需要重新进行登录，而且为了下次能进入第一个条件，将token之为null
                return new BaseResponse("由于长时间未登录，需要重新进行验证",ConstResponse.STATUS_TOKEN_ERROR);
            }
        }
    }

    @RequestMapping("/register")
    private BaseResponse register(@RequestParam("mobile") String mobile, @RequestParam("password") String password, @RequestParam("username") String username) {
        //验证是否进入该action
        System.out.println("注册成功进去了");
        System.out.println("mobile=" + mobile + ",password=" + password + ",username=" + username);

        //进入插入用户的操作
        //先设置用户的头像地址为null，之后能够上传头像再进行修改
        //需要保证手机号和用户名的唯一性
        if(userService.isPhone(mobile)){
            //表示该手机号已注册
            return new BaseResponse("该手机号已被注册", ConstResponse.STATUS_PHONE_HAVE);
        }else if(userService.isUsername(username)){
            //表示该用户名已存在
            return new BaseResponse("该用户名已存在", ConstResponse.STATUS_USERNAME_HAVE);
        }else {
            User user = new User(null, mobile, username, password, null, "F:\\BaiduNetdiskDownload\\androidProject\\uploadimg\\1554716481967.jpg");
            if (userService.insertuser(user)) {
                //查询刚刚插入的数据
                 User insertUser = userService.findUserByPhone(mobile);
                 if(insertUser != null){
                     //注册成功后需要发送插入一条数据
                     MessageWithBLOBs message = new MessageWithBLOBs();
                     message.setMessageid(null);
                     message.setMessagetitle("恭喜你，注册成功");
                     message.setMessagecontent("欢迎您使用‘您的声音’调查app，您可以使用此app完成调查发起、调查提交、词云展示的功能。这个app分为四大模块，包括主页、我的参与、我的调查，个人中心。");
                     //时间
                     SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                     message.setSendtime(simpleDateFormat.format(new Date()));
                     message.setUserid(insertUser.getUserid());
                     //插入一条消息
                     messageService.insertMessage(message);
                     //表示注册成功，返回相关值
                     return new DataResponse(insertUser, ConstResponse.DESC_OK, ConstResponse.STATUS_OK);
                 }
                //还是需要将数据查出来
            } else {
                //表示注册失败，返回相关值
                new BaseResponse(ConstResponse.DESC_PARAM, ConstResponse.STATUS_PARAM_ERROR);
            }
        }
        return new BaseResponse(ConstResponse.DESC_PARAM,ConstResponse.STATUS_PARAM_ERROR);
    }

    @RequestMapping("/resetPassword")
    private BaseResponse resetPassword(@RequestParam("mobile") String mobile, @RequestParam("password") String password) {
        //验证是否进入该action
        System.out.println("修改密码成功进去了");
        System.out.println("mobile=" + mobile + ",password=" + password);

       //首先根据手机号查询用户
        User user = userService.findUserByPhone(mobile);

        if(user == null){
            //表示根据手机号查询不到此用户
            //提示用户需要先注册
            return new BaseResponse("该手机号未被注册，请先注册", ConstResponse.STATUS_PARAM_ERROR);
        }else{
            //表示根据手机号可以查询到用户

            //修改手机号
            user.setPassword(password);
            if(userService.updateUserById(user)){
                //修改成功
                return new DataResponse(user, ConstResponse.DESC_OK, ConstResponse.STATUS_OK);
            }else{
                return new BaseResponse("网络出错，请重新修改", ConstResponse.STATUS_PHONE_HAVE);
            }
        }
    }

    @RequestMapping("/updatePerson")
    private BaseResponse updatePerson(@RequestParam("mobile") String mobile, @RequestParam("username") String username,@RequestParam("userid") String userid) {
        //验证是否进入该action
        System.out.println("修改用户其他信息成功进去了");
        System.out.println("mobile=" + mobile + ",username=" + username);

        //首先根据手机号查询用户
        User user = userService.findUserByUserid(userid);

        if(user == null){
            return new BaseResponse("网络出错，请重新修改", ConstResponse.STATUS_PHONE_HAVE);
        }else{
            //表示根据手机号可以查询到用户
            if(userService.isPhone(mobile)){
                //表示数据库中该手机号已经被使用
                return new BaseResponse("该手机号已经被使用，请重新输入", ConstResponse.STATUS_PHONE_HAVE);
            }else{
                user.setPhone(mobile);
                user.setUsername(username);
                if(userService.updateUserById(user)){
                    //修改成功
                    return new DataResponse(user, ConstResponse.DESC_OK, ConstResponse.STATUS_OK);
                }else{
                    return new BaseResponse("网络出错，请重新修改", ConstResponse.STATUS_PHONE_HAVE);
                }
            }
        }
    }

    @RequestMapping("/updatePersonHeadImg")
    private BaseResponse updatePersonHeadImg(@RequestParam("file") MultipartFile file,HttpServletRequest request,@RequestParam("userid") String userid) {

        //验证是否进入该action
        System.out.println("上传头像");
        if (file.isEmpty()) {
            System.out.println("文件为空");
        }

        String contentType = file.getContentType();   //图片文件类型
        System.out.println("contentType="+contentType);
        String fileName = file.getOriginalFilename();  //图片名字

        //文件存放路径
        String filePath = "F:\\BaiduNetdiskDownload\\androidProject\\uploadimg\\";

        //调用文件处理类FileUtil，处理文件，将文件写入指定位置
        try {
            String path = Utils.uploadFile(file.getBytes(), filePath, fileName);
            //需要将Path修改到该用户中
            User user =userService.findUserByUserid(userid);
            if(user != null){
                //表示存在
                System.out.println("path="+path);
                user.setHeadaddress(path);
                if(userService.updateUserById(user)){
                    return new DataResponse(user, ConstResponse.DESC_OK, ConstResponse.STATUS_OK);
                }else{
                    return new BaseResponse("网络不给力，请重新上传头像", ConstResponse.STATUS_PARAM_ERROR);
                }
            }else{
                //表示不存在此用户
                return new BaseResponse("您需要重新登录进行头像修改", ConstResponse.STATUS_PARAM_ERROR);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return new BaseResponse("网络不给力，请重新上传头像", ConstResponse.STATUS_PARAM_ERROR);
    }
}
