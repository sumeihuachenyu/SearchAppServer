package com.example.Server.entity;

public class Message {
    private Integer messageid;

    private String sendtime;

    private Integer userid;

    public Message(Integer messageid, String sendtime, Integer userid) {
        this.messageid = messageid;
        this.sendtime = sendtime;
        this.userid = userid;
    }

    public Message() {
        super();
    }

    public Integer getMessageid() {
        return messageid;
    }

    public void setMessageid(Integer messageid) {
        this.messageid = messageid;
    }

    public String getSendtime() {
        return sendtime;
    }

    public void setSendtime(String sendtime) {
        this.sendtime = sendtime == null ? null : sendtime.trim();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
}