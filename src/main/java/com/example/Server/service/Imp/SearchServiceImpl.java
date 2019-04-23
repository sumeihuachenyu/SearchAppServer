package com.example.Server.service.Imp;

import com.example.Server.dao.JoinRecordMapper;
import com.example.Server.dao.SearchMapper;
import com.example.Server.dao.UserMapper;
import com.example.Server.entity.*;
import com.example.Server.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2019-04-10.
 */
@Service("SearchService")
public class SearchServiceImpl implements SearchService {

    @Autowired
    private SearchMapper searchMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private JoinRecordMapper joinRecordMapper;

    @Override
    public boolean insertSearch(Search search) {
        if(searchMapper.insert(search) > 0){
            return true;
        }
        return false;
    }

    @Override
    public List<SearchAndPerson> getHomeSearchs(SearchVar searchVar) {
        System.out.print("进入1");
        //不仅是调查信息，连用户信息也需要查询
        List<SearchAndPerson> searchAndPeoples = new ArrayList<SearchAndPerson>();
        List<Search> searchs = null;
        SearchExample searchExample = new SearchExample();
       SearchExample.Criteria criteria = searchExample.createCriteria();

        if(!searchVar.getType().isEmpty()){
            System.out.print("进入类型条件");
            criteria.andSearchtypeEqualTo(searchVar.getType());
        }
        if(!searchVar.getTitle().isEmpty()){
            System.out.print("进入标题条件");
            criteria.andSearchtitleLike("%"+searchVar.getTitle()+"%");
        }

        if(!searchVar.getPaixu().isEmpty()){
            System.out.print("进入2 ||| searchVar.getPaixu()="+searchVar.getPaixu());
            if("desc".equals(searchVar.getPaixu())){
                System.out.print("jhjjjjjjhk");
                searchs = searchMapper.selectByExampleDesc(searchExample);
                System.out.print("searchs="+searchs);
                for(int i = 0; i < searchs.size();i++) {
                    Integer userid = searchs.get(i).getSearchpersonid();//发起人id
                    User user = userMapper.selectByPrimaryKey(userid);
                    if (userMapper.selectByPrimaryKey(userid) != null) {
                        SearchAndPerson searchAndPerson = new SearchAndPerson();
                        searchAndPerson.setUserid(userid);
                        searchAndPerson.setUsername(user.getUsername());
                        searchAndPerson.setPhone(user.getPhone());
                        searchAndPerson.setHeadaddress(user.getHeadaddress());
                        searchAndPerson.setSearchtitle(searchs.get(i).getSearchtitle());
                        searchAndPerson.setSearchsubmittime(searchs.get(i).getSearchsubmittime());
                        searchAndPerson.setSearchid(searchs.get(i).getSearchid());
                        searchAndPerson.setSearchpersonid(searchs.get(i).getSearchpersonid());
                        searchAndPerson.setIsstop(searchs.get(i).getIsstop());
                        searchAndPerson.setSearchtype(searchs.get(i).getSearchtype());
                        searchAndPerson.setQuestionone(searchs.get(i).getQuestionone());
                        searchAndPerson.setQuestiontwo(searchs.get(i).getQuestiontwo());
                        searchAndPerson.setQuestionthree(searchs.get(i).getQuestionthree());
                        searchAndPerson.setRemarks(searchs.get(i).getRemarks());
                        searchAndPeoples.add(searchAndPerson);
                    }
                }
            }
            if("asc".equals(searchVar.getPaixu())){
                System.out.print("进入3");
                searchs = searchMapper.selectByExampleAsc(searchExample);

                for(int i = 0; i < searchs.size();i++){
                    Integer userid = searchs.get(i).getSearchpersonid();//发起人id
                    System.out.println("userid="+userid);
                    User user =  userMapper.selectByPrimaryKey(userid);
                    System.out.println("user="+user);
                    if(userMapper.selectByPrimaryKey(userid) != null){
                        SearchAndPerson searchAndPerson = new SearchAndPerson();
                        searchAndPerson.setUserid(userid);
                        searchAndPerson.setUsername(user.getUsername());
                        searchAndPerson.setPhone(user.getPhone());
                        searchAndPerson.setHeadaddress(user.getHeadaddress());
                        searchAndPerson.setSearchtitle(searchs.get(i).getSearchtitle());
                        searchAndPerson.setSearchsubmittime(searchs.get(i).getSearchsubmittime());
                        searchAndPerson.setSearchid(searchs.get(i).getSearchid());
                        searchAndPerson.setSearchpersonid(searchs.get(i).getSearchpersonid());
                        searchAndPerson.setIsstop(searchs.get(i).getIsstop());
                        searchAndPerson.setSearchtype(searchs.get(i).getSearchtype());
                        searchAndPerson.setQuestionone(searchs.get(i).getQuestionone());
                        searchAndPerson.setQuestiontwo(searchs.get(i).getQuestiontwo());
                        searchAndPerson.setQuestionthree(searchs.get(i).getQuestionthree());
                        searchAndPerson.setRemarks(searchs.get(i).getRemarks());
                        searchAndPeoples.add(searchAndPerson);
                    }
                }

            }
        }

        System.out.print("进入4");
        if(searchAndPeoples.size() > 0){
            System.out.print("进入5");
            for(int i = 0;i<searchAndPeoples.size();i++){
                System.out.println("searchAndPeoples = "+searchAndPeoples.get(i));
            }
            return searchAndPeoples;
        }
        return null;
    }

    @Override
    public List<SearchAndPerson> getSearchsBySubmitPerson(String userid, SearchVar searchVar) {
        System.out.print("进入1");
        //不仅是调查信息，连用户信息也需要查询
        List<SearchAndPerson> searchAndPeoples = new ArrayList<SearchAndPerson>();
        List<Search> searchs = null;
        SearchExample searchExample = new SearchExample();
        SearchExample.Criteria criteria = searchExample.createCriteria();
        criteria.andSearchpersonidEqualTo(new Integer(userid));

        if(!searchVar.getType().isEmpty()){
            System.out.print("进入类型条件");
            criteria.andSearchtypeEqualTo(searchVar.getType());
        }
        if(!searchVar.getTitle().isEmpty()){
            System.out.print("进入标题条件");
            criteria.andSearchtitleLike("%"+searchVar.getTitle()+"%");
        }

        if(!searchVar.getPaixu().isEmpty()){
            System.out.print("进入2 ||| searchVar.getPaixu()="+searchVar.getPaixu());
            if("desc".equals(searchVar.getPaixu())){
                System.out.print("jhjjjjjjhk");
                searchs = searchMapper.selectByExampleDesc(searchExample);
                System.out.print("searchs="+searchs);
                User user = userMapper.selectByPrimaryKey(new Integer(userid));
                for(int i = 0; i < searchs.size();i++) {
                    //Integer useridTemp = searchs.get(i).getSearchpersonid();//发起人id
                    //对于查找某一个人发布的所有调查，则这个发布人id就是固定的，就是传递过来的userid
                    if (user != null) {
                        SearchAndPerson searchAndPerson = new SearchAndPerson();
                        searchAndPerson.setUserid(new Integer(userid));
                        searchAndPerson.setUsername(user.getUsername());
                        searchAndPerson.setPhone(user.getPhone());
                        searchAndPerson.setHeadaddress(user.getHeadaddress());
                        searchAndPerson.setSearchtitle(searchs.get(i).getSearchtitle());
                        searchAndPerson.setSearchsubmittime(searchs.get(i).getSearchsubmittime());
                        searchAndPerson.setSearchid(searchs.get(i).getSearchid());
                        searchAndPerson.setSearchpersonid(searchs.get(i).getSearchpersonid());
                        searchAndPerson.setIsstop(searchs.get(i).getIsstop());
                        searchAndPerson.setSearchtype(searchs.get(i).getSearchtype());
                        searchAndPerson.setQuestionone(searchs.get(i).getQuestionone());
                        searchAndPerson.setQuestiontwo(searchs.get(i).getQuestiontwo());
                        searchAndPerson.setQuestionthree(searchs.get(i).getQuestionthree());
                        searchAndPerson.setRemarks(searchs.get(i).getRemarks());
                        searchAndPeoples.add(searchAndPerson);
                    }
                }
            }
            if("asc".equals(searchVar.getPaixu())){
                System.out.print("进入3");
                searchs = searchMapper.selectByExampleAsc(searchExample);
                User user = userMapper.selectByPrimaryKey(new Integer(userid));

                for(int i = 0; i < searchs.size();i++){
                   // Integer userid = searchs.get(i).getSearchpersonid();//发起人id
                   // System.out.println("userid="+userid);
                    //User user =  userMapper.selectByPrimaryKey(userid);
                    //System.out.println("user="+user);
                    if(user != null){
                        SearchAndPerson searchAndPerson = new SearchAndPerson();
                        searchAndPerson.setUserid(new Integer(userid));
                        searchAndPerson.setUsername(user.getUsername());
                        searchAndPerson.setPhone(user.getPhone());
                        searchAndPerson.setHeadaddress(user.getHeadaddress());
                        searchAndPerson.setSearchtitle(searchs.get(i).getSearchtitle());
                        searchAndPerson.setSearchsubmittime(searchs.get(i).getSearchsubmittime());
                        searchAndPerson.setSearchid(searchs.get(i).getSearchid());
                        searchAndPerson.setSearchpersonid(searchs.get(i).getSearchpersonid());
                        searchAndPerson.setIsstop(searchs.get(i).getIsstop());
                        searchAndPerson.setSearchtype(searchs.get(i).getSearchtype());
                        searchAndPerson.setQuestionone(searchs.get(i).getQuestionone());
                        searchAndPerson.setQuestiontwo(searchs.get(i).getQuestiontwo());
                        searchAndPerson.setQuestionthree(searchs.get(i).getQuestionthree());
                        searchAndPerson.setRemarks(searchs.get(i).getRemarks());
                        searchAndPeoples.add(searchAndPerson);
                    }
                }

            }
        }

        System.out.print("进入4");
        if(searchAndPeoples.size() > 0){
            System.out.print("进入5");
            for(int i = 0;i<searchAndPeoples.size();i++){
                System.out.println("searchAndPeoples = "+searchAndPeoples.get(i));
            }
            return searchAndPeoples;
        }

        return null;
    }

    @Override
    public List<JoinSearchPerson> getSearchsByJoinPerson(String userid, SearchVar searchVar) {
        //这个userid指的是参与人的id，需要先查询参与记录：管谁发布的，只要是我参与的就行
        List<JoinSearchPerson> joinSearchPersonList = new ArrayList<>();
        List<JoinSearchPerson> joinSearchPersonList1 = new ArrayList<>();
        List<Search> searchs = null;
        JoinRecordExample joinRecordExample = new JoinRecordExample();
        joinRecordExample.createCriteria().andJoinpersonidEqualTo(new Integer(userid));
        List<JoinRecord> records = joinRecordMapper.selectByExample(joinRecordExample);
        if(records.size() > 0){
            //该参与记录中的每一条中的调查id去获取参与记录，而用户是发布人的用户，需要从searchid中去寻找
            List<Integer> searchids = new ArrayList<>();
            for(int i=0;i<records.size();i++){
                double searchid1 = Double.parseDouble(records.get(i).getSearchid().trim());
                int searchid2 = new Double(searchid1).intValue();
                searchids.add(searchid2);
            }
            for(int k=0;k<searchids.size();k++){
                System.out.println("searchids="+searchids.get(k));
            }
            SearchExample searchExample = new SearchExample();
            SearchExample.Criteria criteria = searchExample.createCriteria();
            criteria.andSearchidIn(searchids);
            if(!searchVar.getType().isEmpty()){
                System.out.print("进入类型条件");
                criteria.andSearchtypeEqualTo(searchVar.getType());
            }
            if(!searchVar.getTitle().isEmpty()){
                System.out.print("进入标题条件");
                criteria.andSearchtitleLike("%"+searchVar.getTitle()+"%");
            }

            if(!searchVar.getPaixu().isEmpty()){
                System.out.print("进入2 ||| searchVar.getPaixu()="+searchVar.getPaixu());
                if("desc".equals(searchVar.getPaixu())){
                    searchs = searchMapper.selectByExampleDesc(searchExample);
                    System.out.print("searchs="+searchs);
                    for(int i = 0; i < searchs.size();i++) {
                        Integer useridtemp = searchs.get(i).getSearchpersonid();//发起人id
                        User user = userMapper.selectByPrimaryKey(useridtemp);
                        if (userMapper.selectByPrimaryKey(useridtemp) != null) {
                            JoinSearchPerson joinSearchPerson = new JoinSearchPerson();
                            joinSearchPerson.setUserid(useridtemp);
                            joinSearchPerson.setUsername(user.getUsername());
                            joinSearchPerson.setPhone(user.getPhone());
                            joinSearchPerson.setHeadaddress(user.getHeadaddress());
                            joinSearchPerson.setSearchtitle(searchs.get(i).getSearchtitle());
                            joinSearchPerson.setSearchsubmittime(searchs.get(i).getSearchsubmittime());
                            joinSearchPerson.setSearchid(searchs.get(i).getSearchid());
                            joinSearchPerson.setSearchpersonid(searchs.get(i).getSearchpersonid());
                            joinSearchPerson.setIsstop(searchs.get(i).getIsstop());
                            joinSearchPerson.setSearchtype(searchs.get(i).getSearchtype());
                            joinSearchPerson.setQuestionone(searchs.get(i).getQuestionone());
                            joinSearchPerson.setQuestiontwo(searchs.get(i).getQuestiontwo());
                            joinSearchPerson.setQuestionthree(searchs.get(i).getQuestionthree());
                            joinSearchPerson.setRemarks(searchs.get(i).getRemarks());
                            joinSearchPersonList.add(joinSearchPerson);
                        }
                    }
                }
                if("asc".equals(searchVar.getPaixu())){
                    System.out.print("进入3");
                    searchs = searchMapper.selectByExampleAsc(searchExample);
                    for(int i = 0; i < searchs.size();i++) {
                        Integer useridtemp = searchs.get(i).getSearchpersonid();//发起人id
                        User user = userMapper.selectByPrimaryKey(useridtemp);
                        if (userMapper.selectByPrimaryKey(useridtemp) != null) {
                            JoinSearchPerson joinSearchPerson = new JoinSearchPerson();
                            joinSearchPerson.setUserid(useridtemp);
                            joinSearchPerson.setUsername(user.getUsername());
                            joinSearchPerson.setPhone(user.getPhone());
                            joinSearchPerson.setHeadaddress(user.getHeadaddress());
                            joinSearchPerson.setSearchtitle(searchs.get(i).getSearchtitle());
                            joinSearchPerson.setSearchsubmittime(searchs.get(i).getSearchsubmittime());
                            joinSearchPerson.setSearchid(searchs.get(i).getSearchid());
                            joinSearchPerson.setSearchpersonid(searchs.get(i).getSearchpersonid());
                            joinSearchPerson.setIsstop(searchs.get(i).getIsstop());
                            joinSearchPerson.setSearchtype(searchs.get(i).getSearchtype());
                            joinSearchPerson.setQuestionone(searchs.get(i).getQuestionone());
                            joinSearchPerson.setQuestiontwo(searchs.get(i).getQuestiontwo());
                            joinSearchPerson.setQuestionthree(searchs.get(i).getQuestionthree());
                            joinSearchPerson.setRemarks(searchs.get(i).getRemarks());
                            joinSearchPersonList.add(joinSearchPerson);
                        }
                    }

                }
            }

            for(int i=0;i<joinSearchPersonList.size();i++){
                Integer searchidTemp = joinSearchPersonList.get(i).getSearchid();
                System.out.println("searchidTemp="+searchidTemp);
                for(int j=0;j<records.size();j++){
                    double searchid1 = Double.parseDouble(records.get(j).getSearchid());
                    Integer searchid2 = new Double(searchid1).intValue();
                    System.out.println("searchid2="+searchid2);
                    if(searchidTemp.toString().equals(searchid2.toString())){
                        System.out.println("进入3searchid2");
                        JoinSearchPerson joinSearchPerson = joinSearchPersonList.get(i);
                        System.out.println("records.get(j).getJoinid()="+records.get(j).getJoinid());
                        joinSearchPerson.setJoinid(records.get(j).getJoinid());
                        System.out.println("records.get(j).getJoinpersonid()="+records.get(j).getJoinpersonid());
                        joinSearchPerson.setJoinpersonid(new Integer(userid));
                        System.out.println("records.get(j).getSearchid()="+records.get(j).getSearchid());
                        joinSearchPerson.setJoinsearchid(records.get(j).getSearchid());
                        System.out.println("records.get(j).getJointime()="+records.get(j).getJointime());
                        joinSearchPerson.setJointime(records.get(j).getJointime());
                        System.out.println("records.get(j).getAnswerone()="+records.get(j).getAnswerone());
                        joinSearchPerson.setAnswerone(records.get(j).getAnswerone());
                        System.out.println("records.get(j).getAnswertwo()="+records.get(j).getAnswertwo());
                        joinSearchPerson.setAnswertwo(records.get(j).getAnswertwo());
                        System.out.println("records.get(j).getAnswerthree()="+records.get(j).getAnswerthree());
                        joinSearchPerson.setAnswerthree(records.get(j).getAnswerthree());
                        System.out.println("records.get(j).getOtheranswer()="+records.get(j).getOtheranswer());
                        joinSearchPerson.setOtheranswer(records.get(j).getOtheranswer());
                        //joinSearchPersonList.remove(i);
                        joinSearchPersonList1.add(joinSearchPerson);
                    }
                }
            }
        }

        if(joinSearchPersonList1.size() > 0){
            System.out.print("进入5");
            for(int i = 0;i<joinSearchPersonList1.size();i++){
                System.out.println("joinSearchPersonList = "+joinSearchPersonList1.get(i));
            }
            return joinSearchPersonList1;
        }

        return null;
    }

    @Override
    public boolean updateIsStop(Search search) {
        if(searchMapper.updateByPrimaryKey(search) >  0){
            return true;
        }
        return false;
    }

    @Override
    public Search getSearchBySearchId(String searchid) {
        double searchid1 = Double.parseDouble(searchid.trim());
        int searchid2 = new Double(searchid1).intValue();
        Search search = searchMapper.selectByPrimaryKey(searchid2);
        if(search != null){
            return search;
        }
        return null;
    }
}
