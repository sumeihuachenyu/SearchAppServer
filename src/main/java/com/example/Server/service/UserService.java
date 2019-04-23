package com.example.Server.service;

import com.example.Server.entity.User;
import com.sun.tools.corba.se.idl.StringGen;

/**
 * Created by lenovo on 2019-03-31.
 */
public interface UserService {
    /**
     * 插入一条数据：用户注册
     * @param user
     */
    public boolean insertuser(User user);

    /***
     * 查询是否存在该手机号
     * @param phone
     * @return
     */
    public boolean isPhone(String phone);

    /**
     * 判断是否存在该用户名
     * @param username
     * @return
     */
    public boolean isUsername(String username);

    /***
     * 根据手机号查询用户
     * @param phone
     * @return
     */
    public User findUserByPhone(String phone);

    /**
     * 根据手机号和密码查询用户
     * @param phone
     * @param password
     * @return
     */
    public User findUserByPhoneAndPassword(String phone,String password);

    /***
     * 根据id修改数据库中的用户数据
     * @param user
     * @return
     */
    public boolean updateUserById(User user);

    /***
     * 根据用户id查询user
     * @param userid
     * @return
     */
    public User findUserByUserid(String userid);
}
