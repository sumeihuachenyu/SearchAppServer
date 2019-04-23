package com.example.Server.wordclound;

import com.kennycason.kumo.CollisionMode;
import com.kennycason.kumo.WordFrequency;
import com.kennycason.kumo.WordCloud;
import com.kennycason.kumo.bg.CircleBackground;
import com.kennycason.kumo.bg.PixelBoundryBackground;
import com.kennycason.kumo.font.KumoFont;
import com.kennycason.kumo.font.scale.LinearFontScalar;
import com.kennycason.kumo.font.scale.SqrtFontScalar;
import com.kennycason.kumo.nlp.FrequencyAnalyzer;
import com.kennycason.kumo.nlp.tokenizers.ChineseWordTokenizer;
import com.kennycason.kumo.palette.ColorPalette;
import com.kennycason.kumo.palette.LinearGradientColorPalette;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.dom4j.DocumentException;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2019-04-15.
 */
public class WordCloudTest {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
//            Process proc;
//            try {
//                proc = Runtime.getRuntime().exec("python F:\\BaiduNetdiskDownload\\androidProject\\wordcloud\\demo1.py");// 执行py文件
//                //用输入输出流来截取结果
//                BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
//                String line = null;
//                while ((line = in.readLine()) != null) {
//                    System.out.println(line);
//                }
//                in.close();
//                proc.waitFor();
//            } catch (IOException e) {
//                e.printStackTrace();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }


        int a = 18;
        int b = 23;
        try {
            //JSON json = {"青岛":1914, "栈桥":1164, "八大关":1098, "崂山": 1030, "五四广场": 793, "花石楼": 597, "天主教堂": 570, "小青岛": 464, "鲁迅公园": 433, "劈柴院": 425, "基督教堂": 363, "第一海水浴场": 341, "公主楼": 326, "海军博物馆": 314, "第二海水浴场": 312, "青岛火车站": 305, "极地海洋世界": 279, "中山公园": 247, "北九水":243, "信号山公园":240};
            //String[] args1 = new String[]{"python", "F:\\BaiduNetdiskDownload\\androidProject\\wordcloud\\demo3.py", String.valueOf(a), String.valueOf(b)};
           // String[] args1 = new String[]{"D:\\python.exe F:\\BaiduNetdiskDownload\\androidProject\\wordcloud\\demo2.py"};
            JSONObject jsonObj = new JSONObject();
            Map <String, Integer> ingredients = new HashMap<String, Integer>();
            ingredients.put("青岛", 1914);
            ingredients.put("栈桥", 1164);
            ingredients.put("八大关",1098);
            ingredients.put("崂山",1030);
            ingredients.put("五四广场",793);
            ingredients.put("花石楼",1030);
            ingredients.put("天主教堂",570);
            ingredients.put("小青岛",464);
            ingredients.put("劈柴院",425);
            ingredients.put("基督教堂",363);
            jsonObj.put("ingredients", ingredients);
            System.out.println(jsonObj.get("ingredients"));//s.replaceAll(" \" ", " \' ");
            String str2 = jsonObj.get("ingredients").toString();//JSON.stringify
            str2 = str2.replaceAll("\"","\'");
            System.out.println(str2);
            String str="{'栈桥':1164,'天主教堂':570,'花石楼':1030,'崂山':1030,'小青岛':464,'劈柴院':425,'五四广场':793,'基督教堂':363,'青岛':0,'八大关':1098}";
            String[] args1 = new String[]{"python", "F:\\BaiduNetdiskDownload\\androidProject\\wordcloud\\demo3.py",str2};
            Process proc = Runtime.getRuntime().exec(args1);// 执行py文件

            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
            proc.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }
}
//{'栈桥':1164,'天主教堂':570,'花石楼':1030,'崂山':1030,'小青岛':464,'劈柴院':425,'五四广场':793,'基督教堂':363,'青岛':1914,'八大关':1098}