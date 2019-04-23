package com.example.Server.service;

import com.example.Server.entity.Type;

import java.util.List;

/**
 * Created by lenovo on 2019-04-09.
 */
public interface TypeService {
    /**
     * 获取所有类型数据
     * @return
     */
    public List<Type> getTypes();
}
