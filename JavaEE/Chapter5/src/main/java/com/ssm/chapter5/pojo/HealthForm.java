package com.ssm.chapter5.pojo;

/**
 * ClassName    chapter5-HealthForm
 * Description  体检表父类
 *
 * @author      xuanc
 * @date        19-5-2 下午5:18
 * @version     1.0
 */ 
public abstract class HealthForm {

    private Long id;
    private Long empId;
    private String heart;
    private String liver;
    private String spleen;
    private String lung;
    private String kidney;
    private String note;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public Long getEmpId() {
        return empId;
    }

    public void setHeart(String heart) {
        this.heart = heart;
    }

    public String getHeart() {
        return heart;
    }

    public void setKidney(String kidney) {
        this.kidney = kidney;
    }

    public String getKidney() {
        return kidney;
    }

    public void setLiver(String liver) {
        this.liver = liver;
    }

    public String getLiver() {
        return liver;
    }

    public void setLung(String lung) {
        this.lung = lung;
    }

    public String getLung() {
        return lung;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNote() {
        return note;
    }

    public void setSpleen(String spleen) {
        this.spleen = spleen;
    }

    public String getSpleen() {
        return spleen;
    }
}
