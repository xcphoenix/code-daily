package com.learn.ssm.chapter3.pojo;

/**
 * ClassName    Chapter3-Role
 * Description  定义角色 POJO
 *
 * @author      xuanc
 * @date        19-4-26 下午7:39
 * @version     1.0
 */ 
public class Role {
    private Long id;
    private String roleName;
    private String note;

    public void setId(Long id) {
        this.id = id;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Long getId() {
        return id;
    }

    public String getNote() {
        return note;
    }

    public String getRoleName() {
        return roleName;
    }
}
