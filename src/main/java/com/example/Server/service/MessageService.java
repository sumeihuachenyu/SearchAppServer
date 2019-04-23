package com.example.Server.service;

import com.example.Server.entity.Message;
import com.example.Server.entity.MessageWithBLOBs;

import java.util.List;

/**
 * Created by lenovo on 2019-04-03.
 */
public interface MessageService {
    /***
     * 插入一条消息数据
     * @param message
     * @return
     */
    public boolean insertMessage(MessageWithBLOBs message);

    /***
     * 获取某一个用户的消息数据
     * @return
     */
    public List<MessageWithBLOBs> getMessage(String userid);
}
