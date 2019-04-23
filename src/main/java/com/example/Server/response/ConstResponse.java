package com.example.Server.response;

/**
 * Created by lenovo on 2019-03-31.
 */
public class ConstResponse {
    /**表示成功*/
    public static final int STATUS_OK = 1000;
    /**表示该手机号已存在*/
    public static final int STATUS_PHONE_HAVE = 1001;
    /**表示该用户名已存在*/
    public static final int STATUS_USERNAME_HAVE = 1002;
    /**表示参数出现错误*/
    public static final int STATUS_PARAM_ERROR = 1003;
    /**表示token失效*/
    public static final int STATUS_TOKEN_ERROR = 1004;

    /**表示操作完成*/
    public static final String DESC_OK = "OK";
    /**表示操作失败*/
    public static final String DESC_PARAM = "error";
}
