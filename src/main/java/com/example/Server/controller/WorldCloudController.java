package com.example.Server.controller;

import com.example.Server.entity.JoinRecord;
import com.example.Server.entity.Search;
import com.example.Server.response.BaseResponse;
import com.example.Server.response.ConstResponse;
import com.example.Server.service.JoinService;
import com.example.Server.service.SearchService;
import net.sf.json.JSONObject;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2019-04-16.
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/cloud")
public class WorldCloudController {
    @Resource
    private SearchService searchService;
    @Resource
    private JoinService joinService;

    @RequestMapping("/show")
    private BaseResponse login(@RequestParam("searchid") String searchid, HttpServletRequest request, HttpServletResponse response) {
        //通过searchid获取是哪个调查，
        //需要获取的是关键字，和次数
        //首先根据searchid查找search
        List<JoinRecord> recordList = null;
        JSONObject jsonObj = new JSONObject();
        int answerAnum = 0;
        int answerBnum = 0;
        int answerCnum = 0;
        Search search = searchService.getSearchBySearchId(searchid);
        Map<String, Integer> ingredients = new HashMap<String, Integer>();
        Map<String, Integer> ingredients2 = new HashMap<String, Integer>();
        Map<String, Integer> temp = new HashMap<String, Integer>();
       if(search != null){
           recordList = joinService.getJoinRecordBySeachid(searchid);
           if(recordList != null){
               for(int i = 0; i < recordList.size();i++){
                   if(recordList.get(i).getAnswerone() == 1){
                       answerAnum +=1;
                   }
                   if(recordList.get(i).getAnswertwo() == 1){
                       answerBnum +=1;
                   }
                   if(recordList.get(i).getAnswerthree() == 1){
                       answerCnum +=1;
                   }
                   if(!recordList.get(i).getOtheranswer().isEmpty() && recordList.get(i).getOtheranswer() != null && recordList.get(i).getOtheranswer() != ""){
                       System.out.print("recordList.get(i).getOtheranswer()="+recordList.get(i).getOtheranswer());
                       if(temp.size() > 0){
                           if(temp.containsKey(recordList.get(i).getOtheranswer())){
                               Integer num=temp.get(recordList.get(i).getOtheranswer());
                               temp.put(recordList.get(i).getOtheranswer(),num++);
                           }else {
                               temp.put(recordList.get(i).getOtheranswer(),1);
                           }
                       }else{
                           temp.put(recordList.get(i).getOtheranswer(),1);//这是进入的第一个其他答案
                       }
                   }
               }
           }else {
               //需要提示的是目前没有人参与过次调查
               return new BaseResponse("目前该项调查未有人参与", ConstResponse.STATUS_TOKEN_ERROR);
           }
       }

        ingredients.put(search.getQuestionone(),answerAnum);
        ingredients.put(search.getQuestiontwo(),answerBnum);
        ingredients.put(search.getQuestionthree(),answerCnum);

        ingredients2.put(search.getQuestionone(),answerAnum);
        ingredients2.put(search.getQuestiontwo(),answerBnum);
        ingredients2.put(search.getQuestionthree(),answerCnum);

       if(temp.size() > 0){
           for(Map.Entry<String,Integer> entry:temp.entrySet()){
               ingredients.put(entry.getKey(),entry.getValue());
               ingredients2.put(entry.getKey(),entry.getValue());
           }
       }
       if(ingredients.size() > 0){
           for(Map.Entry<String,Integer> entry:ingredients2.entrySet()){
              if(entry.getValue() == 0){
                  ingredients.remove(entry.getKey());
              }
           }
           ///获取词云图片
           if(ingredients.size() > 0){
               jsonObj.put("ingredients", ingredients);
               System.out.println(jsonObj.get("ingredients"));//s.replaceAll(" \" ", " \' ");
               String str2 = jsonObj.get("ingredients").toString();//JSON.stringify
               str2 = str2.replaceAll("\"","\'");
               System.out.println(str2);

               String[] args1 = new String[]{"python", "F:\\BaiduNetdiskDownload\\androidProject\\wordcloud\\demo3.py",str2};
               Process proc = null;// 执行py文件
               try {
                   proc = Runtime.getRuntime().exec(args1);
                   BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
                   String line = null;
                   while ((line = in.readLine()) != null) {
                       System.out.println(line);
                   }
                   in.close();
                   proc.waitFor();
               } catch (Exception e1) {
                   e1.printStackTrace();
               }
           }

           String fileUrl = "F:\\BaiduNetdiskDownload\\androidProject\\wordcloud\\wordcloud1.png";
           String imageName = "wordcloud.png";
           if (fileUrl != null) {
               //当前是从该工程的WEB-INF//File//下获取文件(该目录可以在下面一行代码配置)然后下载到C:\\users\\downloads即本机的默认下载的目录
               //  /* String realPath = request.getServletContext().getRealPath(
               // "//WEB-INF//");*/
               //  /*File file = new File(realPath, fileName);*/
                File file = new File(fileUrl);
                if (file.exists()) {
                    response.setContentType("application/force-download");// 设置强制下载不打开
                    response.addHeader("Content-Disposition",
                            "attachment;fileName=" + imageName);// 设置文件名         //
                    byte[] buffer = new byte[1024];
                    FileInputStream fis = null;
                    BufferedInputStream bis = null;
                    try {
                        fis = new FileInputStream(file);
                        bis = new BufferedInputStream(fis);
                        OutputStream os = response.getOutputStream();
                        int i = bis.read(buffer);
                        while (i != -1) {
                            os.write(buffer, 0, i);
                            i = bis.read(buffer);
                        }
                        System.out.println("success");
                        return new BaseResponse("发送成功", ConstResponse.STATUS_OK);
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        if (bis != null) {
                            try {
                                bis.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        if (fis != null) {
                            try {
                                fis.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
           }
       }
        return new BaseResponse("发送成功", ConstResponse.STATUS_OK);
    }
}
