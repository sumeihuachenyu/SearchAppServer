package com.example.Server.response;

/**
 * Created by lenovo on 2019-03-31.
 */
public class BaseResponse {
    public String desc;
    public int status;

    public BaseResponse(){}

    public BaseResponse(String desc, int status) {
        this.desc = desc;
        this.status = status;
    }
}
