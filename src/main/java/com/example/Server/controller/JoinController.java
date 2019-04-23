package com.example.Server.controller;

import com.example.Server.dao.JoinRecordMapper;
import com.example.Server.entity.JoinRecord;
import com.example.Server.response.BaseResponse;
import com.example.Server.response.ConstResponse;
import com.example.Server.service.JoinService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lenovo on 2019-04-14.
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/join")
public class JoinController {
    @Resource
    private JoinService joinService;

    @RequestMapping("/insert")
    private BaseResponse insertSearch(@RequestParam("searchid") String searchid, @RequestParam("userid") String userid, @RequestParam("answerone") String answerone,
                                      @RequestParam("answertwo") String answertwo, @RequestParam("answerthree") String answerthree,
                                      @RequestParam("otheranswer") String otheranswer) {

        System.out.println("进入JOin插入");
        System.out.println("searchid="+searchid+",userid="+userid+",answerone="+answerone+"answertwo="+answertwo+"answerthree="+answerthree+"=otheranswer="+otheranswer);

        JoinRecord joinRecord = new JoinRecord();
        joinRecord.setJoinid(null);
        joinRecord.setJoinpersonid(new Integer(userid));
        joinRecord.setAnswerone(new Integer(answerone));
        joinRecord.setAnswertwo(new Integer(answertwo));
        joinRecord.setAnswerthree(new Integer(answerthree));
        joinRecord.setOtheranswer(otheranswer);
        joinRecord.setSearchid(searchid);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        joinRecord.setJointime(simpleDateFormat.format(new Date()));

        if(joinService.getJoinRecord(userid,searchid) != null){
            System.out.print("您已经参与过，无法再次参与");
            return new BaseResponse("您已经参与过，无法再次参与", ConstResponse.STATUS_PARAM_ERROR);
        }
        if(joinService.insert(joinRecord)){
            System.out.print("参与成功");
            return new BaseResponse("参与成功", ConstResponse.STATUS_OK);
        }else{
            return new BaseResponse("网络出错，请重新发布",ConstResponse.STATUS_PARAM_ERROR);
        }
    }
}
