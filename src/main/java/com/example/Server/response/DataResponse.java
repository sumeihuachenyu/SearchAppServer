package com.example.Server.response;

/**
 * Created by lenovo on 2019-03-31.
 */
public class DataResponse extends BaseResponse {
    public Object data;

    public DataResponse(){}

    public DataResponse(Object data, String desc, int status) {
        super(desc,status);
        this.data = data;
    }
}
