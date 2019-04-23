package com.example.Server.service;

import com.example.Server.entity.JoinSearchPerson;
import com.example.Server.entity.Search;
import com.example.Server.entity.SearchAndPerson;
import com.example.Server.entity.SearchVar;

import java.util.List;

/**
 * Created by lenovo on 2019-04-10.
 */
public interface SearchService {
    /**
     * 插入一条调查记录
     * @param search
     * @return
     */
    public boolean insertSearch(Search search);

    /**
     * 针对首页，获取search列表数据，只需要知道类型、排序调查主题即可
     * @return
     */
    public List<SearchAndPerson> getHomeSearchs(SearchVar search);

    /**
     * 针对调查页，获取的是search列表数据，需要知道发起人id，类型、排序和调查主题
     * 主要是谁发起的调查
     * 可以直接根据发起人id查询
     * @param userid
     * @param searchVar
     * @return
     */
    public List<SearchAndPerson> getSearchsBySubmitPerson(String userid,SearchVar searchVar);

    /**
     * 针对参与页，获取的是search列表数据，需要知道参与人id，类型、排序和调查主题
     * 主要是谁参与的调查
     * 需要利用参与人id获取调查id，然后根据调查id数据获取数据
     * @param userid
     * @param searchVar
     * @return
     */
    public List<JoinSearchPerson> getSearchsByJoinPerson(String userid, SearchVar searchVar);

    /**
     * 修改search记录中的isstop字段为0
     * @param search
     * @return
     */
    public boolean updateIsStop(Search search);

    /**
     * 根据主键查询调查记录
     * @param searchid
     * @return
     */
    public Search getSearchBySearchId(String searchid);
}
