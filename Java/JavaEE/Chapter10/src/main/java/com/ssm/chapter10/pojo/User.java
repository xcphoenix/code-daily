package com.ssm.chapter10.pojo;

/**
 * ClassName    Chapter11-User
 * Description  
 *
 * @author      xuanc
 * @date        19-5-19 下午6:13
 * @version     1.0
 */ 
public class User {

    private Long id;
    private String userName;
    private String note;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
