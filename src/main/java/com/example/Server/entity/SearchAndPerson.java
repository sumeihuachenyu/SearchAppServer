package com.example.Server.entity;

/**
 * Created by lenovo on 2019-04-11.
 */
public class SearchAndPerson {
    private Integer searchid;

    private String searchtitle;

    private String searchsubmittime;

    private String searchtype;

    private Integer searchpersonid;

    private String questionone;

    private String questiontwo;

    private String questionthree;

    private String remarks;

    private Integer isstop;

    private Integer userid;

    private String phone;

    private String username;


    private String headaddress;

    public Integer getSearchid() {
        return searchid;
    }

    public void setSearchid(Integer searchid) {
        this.searchid = searchid;
    }

    public String getSearchtitle() {
        return searchtitle;
    }

    public void setSearchtitle(String searchtitle) {
        this.searchtitle = searchtitle;
    }

    public String getSearchsubmittime() {
        return searchsubmittime;
    }

    public void setSearchsubmittime(String searchsubmittime) {
        this.searchsubmittime = searchsubmittime;
    }

    public String getSearchtype() {
        return searchtype;
    }

    public void setSearchtype(String searchtype) {
        this.searchtype = searchtype;
    }

    public Integer getSearchpersonid() {
        return searchpersonid;
    }

    public void setSearchpersonid(Integer searchpersonid) {
        this.searchpersonid = searchpersonid;
    }

    public String getQuestionone() {
        return questionone;
    }

    public void setQuestionone(String questionone) {
        this.questionone = questionone;
    }

    public String getQuestiontwo() {
        return questiontwo;
    }

    public void setQuestiontwo(String questiontwo) {
        this.questiontwo = questiontwo;
    }

    public String getQuestionthree() {
        return questionthree;
    }

    public void setQuestionthree(String questionthree) {
        this.questionthree = questionthree;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getIsstop() {
        return isstop;
    }

    public void setIsstop(Integer isstop) {
        this.isstop = isstop;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getHeadaddress() {
        return headaddress;
    }

    public void setHeadaddress(String headaddress) {
        this.headaddress = headaddress;
    }

    @Override
    public String toString() {
        return "SearchAndPerson{" +
                "searchid=" + searchid +
                ", searchtitle='" + searchtitle + '\'' +
                ", searchsubmittime='" + searchsubmittime + '\'' +
                ", searchtype='" + searchtype + '\'' +
                ", searchpersonid=" + searchpersonid +
                ", questionone='" + questionone + '\'' +
                ", questiontwo='" + questiontwo + '\'' +
                ", questionthree='" + questionthree + '\'' +
                ", remarks='" + remarks + '\'' +
                ", isstop=" + isstop +
                ", userid=" + userid +
                ", phone='" + phone + '\'' +
                ", username='" + username + '\'' +
                ", headaddress='" + headaddress + '\'' +
                '}';
    }
}
