package com.example.Server.service;

import com.example.Server.entity.Captcha;

import javax.persistence.Transient;

/**
 * Created by lenovo on 2019-03-10.
 */
public interface CaptchaService {
    /**
     * 查询数据库中是否存在该手机号
     * @param phone
     * @return
     */
    public boolean isHave(String phone);

    /**
     * 插入一条数据
     * @param captcha
     * @return
     */
    public boolean insertCaptcha(Captcha captcha);

    /**
     * 更新一条数据
     * @param captcha
     * @return
     */
    public boolean updateCaptcha(Captcha captcha);

    /**
     * 查询当前数据
     */
    public Captcha selectCaptcha(String mbile);
}
