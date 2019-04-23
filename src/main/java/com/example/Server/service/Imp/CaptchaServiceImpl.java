package com.example.Server.service.Imp;

import com.example.Server.dao.CaptchaMapper;
import com.example.Server.entity.Captcha;
import com.example.Server.entity.CaptchaExample;
import com.example.Server.service.CaptchaService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.Transient;
import java.util.List;

/**
 * Created by lenovo on 2019-03-10.
 */
@Service("CaptchaService")
public class CaptchaServiceImpl implements CaptchaService {
    @Resource
    private CaptchaMapper captchaMapper;

    /**
     * 查看数据之后是否存在该手机号
     * @param phone
     * @return
     */
    @Override
    public boolean isHave(String phone) {
        CaptchaExample captchaExample = new CaptchaExample();
        captchaExample.createCriteria().andPhoneEqualTo(phone);
        List<Captcha> captchas = captchaMapper.selectByExample(captchaExample);
        if(captchas.size() > 0){
            return true;
        }
        return false;
    }

    @Override
    @Transient
    public boolean insertCaptcha(Captcha captcha){
        int code = captchaMapper.insert(captcha);
        if(code > 0){
            return true;
        }
        return false;
    }

    @Override
    @Transient
    public boolean updateCaptcha(Captcha captcha) {
        int code = captchaMapper.updateByPrimaryKey(captcha);
        if(code > 0){
            return true;
        }
        return false;
    }

    /**
     * 查询某条数据，主要是为了获取某条数据
     * @param mbile
     * @return
     */
    @Override
    public Captcha selectCaptcha(String mbile) {
        CaptchaExample captchaExample = new CaptchaExample();
        captchaExample.createCriteria().andPhoneEqualTo(mbile);
        List<Captcha> captchas = captchaMapper.selectByExample(captchaExample);
        return captchas.get(0);
    }


}
