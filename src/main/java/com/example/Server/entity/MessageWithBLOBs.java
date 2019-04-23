package com.example.Server.entity;

public class MessageWithBLOBs extends Message {
    private String messagetitle;

    private String messagecontent;

    public MessageWithBLOBs(Integer messageid, String sendtime, Integer userid, String messagetitle, String messagecontent) {
        super(messageid, sendtime, userid);
        this.messagetitle = messagetitle;
        this.messagecontent = messagecontent;
    }

    public MessageWithBLOBs() {
        super();
    }

    public String getMessagetitle() {
        return messagetitle;
    }

    public void setMessagetitle(String messagetitle) {
        this.messagetitle = messagetitle == null ? null : messagetitle.trim();
    }

    public String getMessagecontent() {
        return messagecontent;
    }

    public void setMessagecontent(String messagecontent) {
        this.messagecontent = messagecontent == null ? null : messagecontent.trim();
    }
}