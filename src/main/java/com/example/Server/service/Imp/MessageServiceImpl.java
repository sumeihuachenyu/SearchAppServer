package com.example.Server.service.Imp;

import com.example.Server.dao.MessageMapper;
import com.example.Server.entity.Message;
import com.example.Server.entity.MessageExample;
import com.example.Server.entity.MessageWithBLOBs;
import com.example.Server.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lenovo on 2019-04-03.
 */
@Service("MessageService")
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageMapper messageMapper;

    @Override
    public boolean insertMessage(MessageWithBLOBs message) {
        if(messageMapper.insert(message) >0){
            return true;
        }
        return false;
    }

    @Override
    public List<MessageWithBLOBs> getMessage(String userid) {
        MessageExample message = new MessageExample();
        message.createCriteria().andUseridEqualTo(new Integer(userid));
        List<MessageWithBLOBs> messageWithBLOBss = messageMapper.selectByExampleWithBLOBs(message);
        if(messageWithBLOBss.size() > 0){
            return messageWithBLOBss;
        }
        return null;
    }
}
