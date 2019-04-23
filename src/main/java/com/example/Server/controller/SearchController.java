package com.example.Server.controller;

import com.example.Server.entity.JoinSearchPerson;
import com.example.Server.entity.Search;
import com.example.Server.entity.SearchAndPerson;
import com.example.Server.entity.SearchVar;
import com.example.Server.response.BaseResponse;
import com.example.Server.response.ConstResponse;
import com.example.Server.response.DataResponse;
import com.example.Server.service.JoinService;
import com.example.Server.service.SearchService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by lenovo on 2019-04-10.
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/search")
public class SearchController {
    @Resource
    private SearchService searchService;
    @Resource
    private JoinService joinService;

    @RequestMapping("/insert")
    private BaseResponse insertSearch(@RequestParam("searchtitle") String searchtitle, @RequestParam("searchtype") String searchtype, @RequestParam("userid") String userid,
                                      @RequestParam("questionone") String questionone,@RequestParam("questiontwo") String questiontwo,@RequestParam("questionthree") String questionthree,
                                      @RequestParam("remarks") String remarks) {
        System.out.print("进入插入");
        System.out.println("searchtitle="+searchtitle);
        System.out.println("searchtype="+searchtype);
        System.out.println("userid="+userid);
        System.out.println("questionone="+questionone);
        System.out.println("questiontwo="+questiontwo);
        System.out.println("questionthree="+questionthree);
        System.out.println("remarks="+remarks);
        //发布时间和id以及是否停止自动写进去

        if("无值".equals(remarks)){
            remarks = "";
        }
        Search search = new Search();
        search.setSearchid(null);
        search.setSearchtitle(searchtitle);
        search.setSearchtype(searchtype);
        search.setSearchpersonid(new Integer(userid));
        search.setQuestionone(questionone);
        search.setQuestiontwo(questiontwo);
        search.setQuestionthree(questionthree);
        search.setRemarks(remarks);
        search.setIsstop(1);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        search.setSearchsubmittime(simpleDateFormat.format(new Date()));

        if(searchService.insertSearch(search)){
           System.out.print("发布成功");
           return new BaseResponse("发布成功", ConstResponse.STATUS_OK);
        }else{
            return new BaseResponse("网络出错，请重新发布",ConstResponse.STATUS_PARAM_ERROR);
        }
    }

    @RequestMapping("/getHomes")
    private BaseResponse getHomes(@RequestParam("searchtitle") String searchtitle, @RequestParam("searchtype") String searchtype, @RequestParam("paixu") String paixu) {
        System.out.print("进入插入");
        System.out.println("searchtitle="+searchtitle);
        System.out.println("searchtype="+searchtype);
        System.out.println("paixu="+paixu);


        if("无值".equals(searchtitle)){
            searchtitle = "";
        }
        if("无值".equals(searchtype)){
            searchtype = "";
        }
        //发布时间和id以及是否停止自动写进去

        SearchVar searchVar = new SearchVar();
        searchVar.setType(searchtype);
        searchVar.setPaixu(paixu);
        searchVar.setTitle(searchtitle);
        System.out.println("searchVar="+searchVar);
        List<SearchAndPerson> searchs = searchService.getHomeSearchs(searchVar);

        if(searchs != null){
            System.out.print("获取数据成功");
            return new DataResponse(searchs,"发布成功", ConstResponse.STATUS_OK);
        }else {
            return new BaseResponse("网络出错，请重新发布",ConstResponse.STATUS_PARAM_ERROR);
        }
    }

    @RequestMapping("/getPersonSearches")
    private BaseResponse getPersonSearches(@RequestParam("userid") String userid,@RequestParam("searchtitle") String searchtitle, @RequestParam("searchtype") String searchtype, @RequestParam("paixu") String paixu) {
        System.out.print("进入插入");
        System.out.println("searchtitle="+searchtitle);
        System.out.println("searchtype="+searchtype);
        System.out.println("paixu="+paixu);


        if("无值".equals(searchtitle)){
            searchtitle = "";
        }
        if("无值".equals(searchtype)){
            searchtype = "";
        }
        //发布时间和id以及是否停止自动写进去

        SearchVar searchVar = new SearchVar();
        searchVar.setType(searchtype);
        searchVar.setPaixu(paixu);
        searchVar.setTitle(searchtitle);
        System.out.println("searchVar="+searchVar);
        List<SearchAndPerson> searchs = searchService.getSearchsBySubmitPerson(userid,searchVar);

        if(searchs != null){
            System.out.print("获取数据成功");
            return new DataResponse(searchs,"获取数据成功", ConstResponse.STATUS_OK);
        }else {
            return new BaseResponse("该用户暂无发布调查记录",ConstResponse.STATUS_PARAM_ERROR);
        }
    }

    @RequestMapping("/updateisStop")
    private BaseResponse updateisStop(@RequestParam("searchid") String searchid) {
        System.out.print("进入插入");
        System.out.println("searchid=" + searchid);

        Search search = searchService.getSearchBySearchId(searchid);

        if (search != null) {
            if(search.getIsstop() == 0){
                return new BaseResponse("该调查已经被停止", ConstResponse.STATUS_PARAM_ERROR);
            }else{
                search.setIsstop(0);
                if (searchService.updateIsStop(search)) {
                    return new BaseResponse("停止调查成功", ConstResponse.STATUS_OK);
                } else {
                    return new BaseResponse("网络出错，请重新操作", ConstResponse.STATUS_PARAM_ERROR);
                }
            }
        }
        return new BaseResponse("网络出错，请重新操作", ConstResponse.STATUS_PARAM_ERROR);
    }

    @RequestMapping("/getJoinSearches")
    private BaseResponse getJoinSearches(@RequestParam("userid") String userid,@RequestParam("searchtitle") String searchtitle, @RequestParam("searchtype") String searchtype, @RequestParam("paixu") String paixu) {
        System.out.print("进入插入");
        System.out.println("searchtitle="+searchtitle);
        System.out.println("searchtype="+searchtype);
        System.out.println("paixu="+paixu);


        if("无值".equals(searchtitle)){
            searchtitle = "";
        }
        if("无值".equals(searchtype)){
            searchtype = "";
        }
        //发布时间和id以及是否停止自动写进去

        SearchVar searchVar = new SearchVar();
        searchVar.setType(searchtype);
        searchVar.setPaixu(paixu);
        searchVar.setTitle(searchtitle);
        System.out.println("searchVar="+searchVar);
        List<JoinSearchPerson> searchs = searchService.getSearchsByJoinPerson(userid,searchVar);
        if(searchs != null){
            System.out.print("获取数据成功");
            return new DataResponse(searchs,"获取数据成功", ConstResponse.STATUS_OK);
        }else {
            return new BaseResponse("该用户暂无参与记录",ConstResponse.STATUS_PARAM_ERROR);
        }
    }

}
