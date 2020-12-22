package com.ssm.chapter5.pojo;

/**
 * ClassName    chapter5-FemaleEmployee
 * Description  
 *
 * @author      xuanc
 * @date        19-5-12 上午10:49
 * @version     1.0
 */ 
public class FemaleEmployee extends Employee {

    private FemaleHealthForm femaleHealthForm = null;

    public FemaleHealthForm getFemaleHealthForm() {
        return femaleHealthForm;
    }

    public void setFemaleHealthForm(FemaleHealthForm femaleHealthForm) {
        this.femaleHealthForm = femaleHealthForm;
    }
}
