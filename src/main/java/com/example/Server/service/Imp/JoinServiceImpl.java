package com.example.Server.service.Imp;

import com.example.Server.dao.JoinRecordMapper;
import com.example.Server.entity.JoinRecord;
import com.example.Server.entity.JoinRecordExample;
import com.example.Server.service.JoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lenovo on 2019-04-14.
 */
@Service("JoinService")
public class JoinServiceImpl implements JoinService {
    @Autowired
    private JoinRecordMapper joinRecordMapper;

    @Override
    public boolean insert(JoinRecord joinRecord) {
        if(joinRecordMapper.insert(joinRecord) > 0){
            return true;
        }
        return false;
    }

    @Override
    public JoinRecord getJoinRecord(String userid, String searchid) {
        JoinRecordExample joinRecordExample = new JoinRecordExample();
        joinRecordExample.createCriteria().andJoinpersonidEqualTo(new Integer(userid)).andSearchidEqualTo(searchid);
        List<JoinRecord> recordList = joinRecordMapper.selectByExample(joinRecordExample);
        if(recordList.size() > 0){
            return recordList.get(0);
        }
        return null;
    }

    @Override
    public List<JoinRecord> getJoinRecordBySeachid(String searchid) {
        JoinRecordExample joinRecordExample = new JoinRecordExample();
        joinRecordExample.createCriteria().andSearchidEqualTo(searchid);
        List<JoinRecord> records = joinRecordMapper.selectByExample(joinRecordExample);
        if(records.size() > 0){
            return records;
        }
        return null;
    }
}
