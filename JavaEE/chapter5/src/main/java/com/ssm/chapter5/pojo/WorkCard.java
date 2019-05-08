package com.ssm.chapter5.pojo;

/**
 * ClassName    chapter5-WorkCard
 * Description  工牌表
 *
 * @author      xuanc
 * @date        19-5-2 下午5:24
 * @version     1.0
 */ 
public class WorkCard {

    private Long id;
    private Long empId;
    private String realName;
    private String department;
    private String mobile;
    private String position;
    private String note;

    public void setNote(String note) {
        this.note = note;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getNote() {
        return note;
    }

    public Long getId() {
        return id;
    }

    public Long getEmpId() {
        return empId;
    }

    public String getDepartment() {
        return department;
    }

    public String getMobile() {
        return mobile;
    }

    public String getPosition() {
        return position;
    }

    public String getRealName() {
        return realName;
    }
}

