package com.example.Server.dao;

import java.util.List;

import com.example.Server.entity.Message;
import com.example.Server.entity.MessageExample;
import com.example.Server.entity.MessageWithBLOBs;
import org.apache.ibatis.annotations.Param;

public interface MessageMapper {
    int countByExample(MessageExample example);

    int deleteByExample(MessageExample example);

    int deleteByPrimaryKey(Integer messageid);

    int insert(MessageWithBLOBs record);

    int insertSelective(MessageWithBLOBs record);

    List<MessageWithBLOBs> selectByExampleWithBLOBs(MessageExample example);

    List<Message> selectByExample(MessageExample example);

    MessageWithBLOBs selectByPrimaryKey(Integer messageid);

    int updateByExampleSelective(@Param("record") MessageWithBLOBs record, @Param("example") MessageExample example);

    int updateByExampleWithBLOBs(@Param("record") MessageWithBLOBs record, @Param("example") MessageExample example);

    int updateByExample(@Param("record") Message record, @Param("example") MessageExample example);

    int updateByPrimaryKeySelective(MessageWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(MessageWithBLOBs record);

    int updateByPrimaryKey(Message record);
}