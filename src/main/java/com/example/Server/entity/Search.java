package com.example.Server.entity;

public class Search {
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

    public Search(Integer searchid, String searchtitle, String searchsubmittime, String searchtype, Integer searchpersonid, String questionone, String questiontwo, String questionthree, String remarks, Integer isstop) {
        this.searchid = searchid;
        this.searchtitle = searchtitle;
        this.searchsubmittime = searchsubmittime;
        this.searchtype = searchtype;
        this.searchpersonid = searchpersonid;
        this.questionone = questionone;
        this.questiontwo = questiontwo;
        this.questionthree = questionthree;
        this.remarks = remarks;
        this.isstop = isstop;
    }

    public Search() {
        super();
    }

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
        this.searchtitle = searchtitle == null ? null : searchtitle.trim();
    }

    public String getSearchsubmittime() {
        return searchsubmittime;
    }

    public void setSearchsubmittime(String searchsubmittime) {
        this.searchsubmittime = searchsubmittime == null ? null : searchsubmittime.trim();
    }

    public String getSearchtype() {
        return searchtype;
    }

    public void setSearchtype(String searchtype) {
        this.searchtype = searchtype == null ? null : searchtype.trim();
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
        this.questionone = questionone == null ? null : questionone.trim();
    }

    public String getQuestiontwo() {
        return questiontwo;
    }

    public void setQuestiontwo(String questiontwo) {
        this.questiontwo = questiontwo == null ? null : questiontwo.trim();
    }

    public String getQuestionthree() {
        return questionthree;
    }

    public void setQuestionthree(String questionthree) {
        this.questionthree = questionthree == null ? null : questionthree.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public Integer getIsstop() {
        return isstop;
    }

    public void setIsstop(Integer isstop) {
        this.isstop = isstop;
    }
}