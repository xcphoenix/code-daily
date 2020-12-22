package com.ssm.chapter9.pojo;

/**
 * ClassName    Chapter11-Role
 * Description  
 *
 * @author      xuanc
 * @date        19-5-19 下午4:31
 * @version     1.0
 */ 
public class Role {
    private Long id;
    private String roleName;
    private String note;

    /**
     * 无参构造函数
     * - 使用 setter 注入
     */
    public Role() {}

    public Role(String roleName, String note) {
        this.roleName = roleName;
        this.note = note;
    }

    /*
     * setter and getter
     */

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
