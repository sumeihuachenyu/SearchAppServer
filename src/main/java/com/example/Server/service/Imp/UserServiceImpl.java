package com.example.Server.service.Imp;

import com.example.Server.dao.UserMapper;
import com.example.Server.entity.User;
import com.example.Server.entity.UserExample;
import com.example.Server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lenovo on 2019-03-31.
 */
@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean insertuser(User user) {
       if(userMapper.insert(user) > 0){
           return true;
       }else{
           return false;
       }
    }

    @Override
    public boolean isPhone(String phone) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andPhoneEqualTo(phone);
        if(userMapper != null){
            List<User> users = userMapper.selectByExample(userExample);
            if(users != null){
                if(users.size() > 0 ){
                    //如果大于0表示存在该有记号的记录
                    return true;
                }
            }
        }
        //如果小于0表示不存在该有记号的记录
        return false;
    }

    @Override
    public boolean isUsername(String username) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(username);
        List<User> users = userMapper.selectByExample(userExample);
        if(users != null){
            if(users.size() > 0 ){
                //如果大于0表示存在该有记号的记录
                return true;
            }
        }
        //如果小于0表示不存在该有记号的记录
        return false;
    }

    @Override
    public User findUserByPhone(String phone) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andPhoneEqualTo(phone);
        List<User> users = userMapper.selectByExample(userExample);
        if(users.size() > 0){
            return users.get(0);
        }
        return null;
    }

    @Override
    public User findUserByPhoneAndPassword(String phone, String password) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andPhoneEqualTo(phone).andPasswordEqualTo(password);
        List<User> users = userMapper.selectByExample(userExample);
        if(users.size() > 0){
            return users.get(0);
        }
        return null;
    }

    @Override
    public boolean updateUserById(User user) {
        if(userMapper.updateByPrimaryKey(user) > 0){
            return true;
        }
        return false;
    }

    @Override
    public User findUserByUserid(String userid) {
        User user = userMapper.selectByPrimaryKey(new Integer(userid));
        if(user != null){
            return user;
        }
        return null;
    }

}
