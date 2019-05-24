package com.ssm.chapter10.pojo;

/**
 * ClassName    Chapter11-Role
 * Description  
 *
 * @author      xuanc
 * @date        19-5-19 下午6:11
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

    public Role() {}

    public Role(Long id, String roleName, String note) {
        this.id = id;
        this.roleName = roleName;
        this.note = note;
    }

}
