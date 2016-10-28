package com.example.administrator.mycontents;

/**
 * Created by Administrator on 2016/10/26.
 */
public class user {
    public final static String NAME = "name";
    public final static String PHONE = "phone";
    public final static String DANWEI = "danwei";
    public final static String QQ = "qq";
    public final static String DIZHI = "dizhi";

    private String name;
    private String phone;
    private String danwei;
    private String qq;
    private String dizhi;
    private int id = -1;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public  String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public  String getDanwei() {
        return danwei;
    }

    public void setDanwei(String danwei) {
        this.danwei = danwei;
    }

    public  String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public  String getDizhi() {
        return dizhi;
    }

    public void setDizhi(String dizhi) {
        this.dizhi = dizhi;
    }
}


