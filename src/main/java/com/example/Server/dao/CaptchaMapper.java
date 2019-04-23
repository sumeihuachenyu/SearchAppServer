package com.example.Server.dao;

import java.util.List;

import com.example.Server.entity.Captcha;
import com.example.Server.entity.CaptchaExample;
import org.apache.ibatis.annotations.Param;

public interface CaptchaMapper {
    int countByExample(CaptchaExample example);

    int deleteByExample(CaptchaExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Captcha record);

    int insertSelective(Captcha record);

    List<Captcha> selectByExample(CaptchaExample example);

    Captcha selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Captcha record, @Param("example") CaptchaExample example);

    int updateByExample(@Param("record") Captcha record, @Param("example") CaptchaExample example);

    int updateByPrimaryKeySelective(Captcha record);

    int updateByPrimaryKey(Captcha record);
}