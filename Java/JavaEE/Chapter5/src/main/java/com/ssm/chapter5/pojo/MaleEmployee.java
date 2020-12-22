package com.ssm.chapter5.pojo;

/**
 * ClassName    chapter5-MaleEmployee
 * Description  
 *
 * @author      xuanc
 * @date        19-5-12 上午10:47
 * @version     1.0
 */ 
public class MaleEmployee extends Employee {

    private MaleHealthForm maleHealthForm = null;

    public MaleHealthForm getMaleHealthForm() {
        return maleHealthForm;
    }

    public void setMaleHealthForm(MaleHealthForm maleHealthForm) {
        this.maleHealthForm = maleHealthForm;
    }
}
