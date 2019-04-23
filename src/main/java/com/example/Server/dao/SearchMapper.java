package com.example.Server.dao;


import java.util.List;

import com.example.Server.entity.Search;
import com.example.Server.entity.SearchExample;
import org.apache.ibatis.annotations.Param;

public interface SearchMapper {
    int countByExample(SearchExample example);

    int deleteByExample(SearchExample example);

    int deleteByPrimaryKey(Integer searchid);

    int insert(Search record);

    int insertSelective(Search record);

    List<Search> selectByExampleDesc(SearchExample example);

    List<Search> selectByExampleAsc(SearchExample example);

    Search selectByPrimaryKey(Integer searchid);

    int updateByExampleSelective(@Param("record") Search record, @Param("example") SearchExample example);

    int updateByExample(@Param("record") Search record, @Param("example") SearchExample example);

    int updateByPrimaryKeySelective(Search record);

    int updateByPrimaryKey(Search record);

}