package com.example.Server.entity;

/**
 * Created by lenovo on 2019-04-14.
 */
public class JoinSearchPerson extends SearchAndPerson {
    private Integer joinid;

    private Integer joinpersonid;

    private String jointime;

    private Integer answerone;

    private Integer answertwo;

    private Integer answerthree;

    private String otheranswer;

    private String joinsearchid;

    public JoinSearchPerson(Integer joinid, Integer joinpersonid, String jointime, Integer answerone, Integer answertwo, Integer answerthree, String otheranswer, String searchid) {
        this.joinid = joinid;
        this.joinpersonid = joinpersonid;
        this.jointime = jointime;
        this.answerone = answerone;
        this.answertwo = answertwo;
        this.answerthree = answerthree;
        this.otheranswer = otheranswer;
        this.joinsearchid = searchid;
    }

    public JoinSearchPerson() {
        super();
    }

    public Integer getJoinid() {
        return joinid;
    }

    public void setJoinid(Integer joinid) {
        this.joinid = joinid;
    }

    public Integer getJoinpersonid() {
        return joinpersonid;
    }

    public void setJoinpersonid(Integer joinpersonid) {
        this.joinpersonid = joinpersonid;
    }

    public String getJointime() {
        return jointime;
    }

    public void setJointime(String jointime) {
        this.jointime = jointime == null ? null : jointime.trim();
    }

    public Integer getAnswerone() {
        return answerone;
    }

    public void setAnswerone(Integer answerone) {
        this.answerone = answerone;
    }

    public Integer getAnswertwo() {
        return answertwo;
    }

    public void setAnswertwo(Integer answertwo) {
        this.answertwo = answertwo;
    }

    public Integer getAnswerthree() {
        return answerthree;
    }

    public void setAnswerthree(Integer answerthree) {
        this.answerthree = answerthree;
    }

    public String getOtheranswer() {
        return otheranswer;
    }

    public void setOtheranswer(String otheranswer) {
        this.otheranswer = otheranswer == null ? null : otheranswer.trim();
    }

    public String getJoinsearchid() {
        return joinsearchid;
    }

    public void setJoinsearchid(String searchid) {
        this.joinsearchid = searchid == null ? null : searchid.trim();
    }

    @Override
    public String toString() {
        return "SearchAndPerson{" +
                "searchid=" + getSearchid() +
                ", searchtitle='" + getSearchtitle() + '\'' +
                ", searchsubmittime='" + getSearchsubmittime() + '\'' +
                ", searchtype='" + getSearchtype() + '\'' +
                ", searchpersonid=" + getSearchpersonid() +
                ", questionone='" + getQuestionone() + '\'' +
                ", questiontwo='" + getQuestiontwo() + '\'' +
                ", questionthree='" + getQuestionthree() + '\'' +
                ", remarks='" + getRemarks() + '\'' +
                ", isstop=" + getIsstop() +
                ", userid=" + getUserid() +
                ", phone='" + getPhone() + '\'' +
                ", username='" + getUsername() + '\'' +
                ", headaddress='" + getHeadaddress() + '\'' +
                '}'+"JoinSearchPerson{" +
                "joinid=" + joinid +
                ", joinpersonid=" + joinpersonid +
                ", jointime='" + jointime + '\'' +
                ", answerone=" + answerone +
                ", answertwo=" + answertwo +
                ", answerthree=" + answerthree +
                ", otheranswer='" + otheranswer + '\'' +
                ", joinsearchid='" + joinsearchid + '\'' +
                '}';
    }
}
