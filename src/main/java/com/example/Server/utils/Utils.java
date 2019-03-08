package com.example.Server.utils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.Enumeration;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by lenovo on 2019-03-08.
 */
public class Utils {


    /**
     * 检查API签名是否合法
     * （1）客户端请求里面会携带签名（客户端利用apiSecret和给定的算法产生签名）
     * （2）服务器端会使用存在服务器端的apiSecret和相同的算法产生一个签名。
     * （3）服务器端对这两个签名进行校验，得出签名的有效性。如果有效，则正常走业务流程，否则拒绝请求。
     *
     * @param request
     * @param apiSecret
     * @return
     */
    public static boolean checkSig(HttpServletRequest request, String apiSecret) throws IOException {
        //1、得到请求方携带的API签名
        String clientSig = null;
        StringBuilder stringA = new StringBuilder();
        Enumeration<String> parameterNames = request.getParameterNames();
        Set<String> keySet = new TreeSet<>();

        //2、将所有业务请求参数按字母先后顺序排序。
        while (parameterNames.hasMoreElements()) {
            String parameterName = parameterNames.nextElement();
            if (parameterName.equals("sign")) {
                //获取客户端的API签名
                clientSig = request.getParameter("sign");
                continue;
            }
            keySet.add(parameterName);
        }

        //3、参数名称和参数值链接成一个字符串A。
        for (String key : keySet) {
            String value = request.getParameter(key);
            if (value == null) {
                continue;
            }
            stringA.append(key);
            stringA.append("=");
            stringA.append(value);
            stringA.append("&");
        }
        stringA.setLength(stringA.length() - 1); // trim the last "&"

        System.out.print("stringA="+stringA);
        //服务器端根据参数生成的签名
        String serverSig = null;

        //4、在字符串A的首尾加上apiSecret接口密匙组成一个新字符串B。
        stringA.append(apiSecret);

        System.out.print("stringB="+stringA);

        // 使用MD5对待签名串求签
        byte[] bytes = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            bytes = md5.digest(stringA.toString().getBytes("UTF-8"));
        } catch (GeneralSecurityException ex) {
            throw new IOException(ex);
        }

        StringBuilder sign = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(bytes[i] & 0xFF);
            if (hex.length() == 1) {
                sign.append("0");
            }
            sign.append(hex);
        }
        System.out.print("clientSig="+clientSig);
        System.out.print("sign="+sign);

        //如果服务器端生成的API签名与客户端请求的API签名是一致的，则请求是可信的，否则就是不可信的。
        return clientSig != null && sign != null && clientSig.equals(sign.toString());
    }
}

