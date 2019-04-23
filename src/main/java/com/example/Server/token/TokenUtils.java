package com.example.Server.token;

import com.example.Server.entity.User;
import com.example.Server.service.UserService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lenovo on 2019-04-01.
 * token生成和校验
 */
public class TokenUtils {
//    private static Map<String,String> MAP_TOKENS = new HashMap<String,String>();
    private User user;
    @Resource
    private UserService userService;
    private static final int VALID_TIME = 60*60*2; // token有效期(秒)
    public static final String TOKEN_ERROR = "F"; // 非法
    public static final String TOKEN_OVERDUE = "G"; // 过期
    public static final String TOKEN_FAILURE = "S"; // 失效
    public static final String TOKEN_OK = "ok"; //检测成功
    /**
     *生成token,该token长度不一致,如需一致,可自行MD5或者其它方式加密一下
     * 该方式的token只存在磁盘上,如果项目是分布式,最好用redis存储
     * @param str: 该字符串可自定义,在校验token时要保持一致
     * @return
     * */
    public static String getToken(String str) {
        String token = TokenEncryptUtils.encoded(getCurrentTime()+","+str);
       // MAP_TOKENS.put(str, token);
        return token;
    }

    /**	 *
     *  校验token的有效性
     *  布局需要检查时效性，还需要检查和数据库中的数据进行比对
     *  * @param token
     *  * @return	 */
    public static String checkToken(String tokenFromSql, String token) {
        if (token == null) {
            return TOKEN_ERROR;
        }

        try{
            String[] tArr = TokenEncryptUtils.decoded(token).split(",");
            if (tArr.length != 2) {
                return TOKEN_ERROR;
            }
            // token生成时间戳
            int tokenTime = Integer.parseInt(tArr[0]);
            // 当前时间戳
            int currentTime = getCurrentTime();
            if (currentTime-tokenTime < VALID_TIME) {
                String userid = tArr[1];

                //String mToken = MAP_TOKENS.get(userid);//表示从数据库中取出数据，根据tokenStr区查找
                if (tokenFromSql == null) {
                    return TOKEN_OVERDUE;
                } else if(!tokenFromSql.equals(token)) {
                    return TOKEN_FAILURE;
                }
                return TOKEN_OK;
            } else {
                return TOKEN_OVERDUE;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return TOKEN_ERROR;
    }

    /***
     * 返回token中隐藏的userid的值，根据该值在数据库中进行查找
     * @param token
     * @return
     */
    public static String getQueryUserid(String token){
        if (token == null) {
            return TOKEN_ERROR;
        }

        try{
            String[] tArr = TokenEncryptUtils.decoded(token).split(",");
            if (tArr.length != 2) {
                return TOKEN_ERROR;
            }
            String userid = tArr[1];
            if(userid != null){
                return userid;
            }
            return null;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**获取当前时间戳（10位整数）*/
    public static int getCurrentTime() {
        return (int)(System.currentTimeMillis()/1000);
    }

    /**	 * 移除过期的token	 */
//    public static void removeInvalidToken() {
//        int currentTime = getCurrentTime();
//        for (Map.Entry<String,String> entry : MAP_TOKENS.entrySet()) {
//            String[] tArr = TokenEncryptUtils.decoded(entry.getValue()).split(",");
//            int tokenTime = Integer.parseInt(tArr[0]);
//            if(currentTime-tokenTime > VALID_TIME){
//                MAP_TOKENS.remove(entry.getKey());
//            }
//        }
//    }

    /**	 * 测试	 * @param args	 */
    public static void main(String[] args) {
        String userid = "1";
        // 获取token
        String token = "44565240545e40505f45495f";
        //String token = TokenUtils.getToken(userid);//根据userid重新生成的
        System.out.println("token Result: " + token);
        // 校验token
        String result = TokenUtils.checkToken(token,"44565240545e40505f45495f");
        System.out.println("checkToken Result: " + result);
        //
        if(result.equals(TOKEN_OK)) {
            System.out.println("==>token verification succeeded!");
        }
    }

}
