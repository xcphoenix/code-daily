package com.ssm.chapter14.pojo;

/**
 * ClassName    Chapter14-Role
 * Description  
 *
 * @author      xuanc
 * @date        19-5-15 下午7:37
 * @version     1.0
 */ 
public class Role {

    private Long id;
    private String roleName;
    private String note;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

}
