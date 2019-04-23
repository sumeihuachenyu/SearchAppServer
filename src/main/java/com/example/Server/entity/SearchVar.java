package com.example.Server.entity;

/**
 * Created by lenovo on 2019-04-10.
 */
public class SearchVar {
    private String type;
    private String paixu;
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPaixu() {
        return paixu;
    }

    public void setPaixu(String paixu) {
        this.paixu = paixu;
    }

    public SearchVar(String type, String paixu, String title) {
        this.type = type;
        this.paixu = paixu;
        this.title = title;
    }

    public SearchVar(String type, String paixu) {
        this.type = type;
        this.paixu = paixu;
    }

    public SearchVar(String type) {
        this.type = type;
    }

    public SearchVar(){}

    @Override
    public String toString() {
        return "SearchVar{" +
                "type='" + type + '\'' +
                ", paixu='" + paixu + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
