package com.example.Server.service;

import com.example.Server.entity.JoinRecord;

import java.util.List;

/**
 * Created by lenovo on 2019-04-14.
 */
public interface JoinService {
    /**
     * 插入一条参与记录数据
     * @param joinRecord
     * @return
     */
    public boolean insert(JoinRecord joinRecord);

    /**
     * 根据参与人userid和调查id查询举例
     * @param userid
     * @param searchid
     * @return
     */
    public JoinRecord getJoinRecord(String userid,String searchid);

    /**
     * 根据searchid查找调查记录
     * @param searchid
     * @return
     */
    public List<JoinRecord> getJoinRecordBySeachid(String searchid);
}
