package com.example.Server.service.Imp;

import com.example.Server.dao.TypeMapper;
import com.example.Server.dao.UserMapper;
import com.example.Server.entity.Type;
import com.example.Server.entity.TypeExample;
import com.example.Server.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lenovo on 2019-04-09.
 */
@Service("TypeService")
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeMapper typeMapper;

    @Override
    public List<Type> getTypes() {
        TypeExample typeExample = new TypeExample();
        typeExample.createCriteria();
        List<Type> types=typeMapper.selectByExample(typeExample);
        if(types.size() >  0){
            return types;
        }
        return null;
    }
}
