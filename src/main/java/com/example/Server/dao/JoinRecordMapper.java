package com.example.Server.dao;

import java.util.List;

import com.example.Server.entity.JoinRecord;
import com.example.Server.entity.JoinRecordExample;
import org.apache.ibatis.annotations.Param;

public interface JoinRecordMapper {
    int countByExample(JoinRecordExample example);

    int deleteByExample(JoinRecordExample example);

    int deleteByPrimaryKey(Integer joinid);

    int insert(JoinRecord record);

    int insertSelective(JoinRecord record);

    List<JoinRecord> selectByExample(JoinRecordExample example);

    JoinRecord selectByPrimaryKey(Integer joinid);

    int updateByExampleSelective(@Param("record") JoinRecord record, @Param("example") JoinRecordExample example);

    int updateByExample(@Param("record") JoinRecord record, @Param("example") JoinRecordExample example);

    int updateByPrimaryKeySelective(JoinRecord record);

    int updateByPrimaryKey(JoinRecord record);
}