package com.ssm.chapter5.pojo;

/**
 * ClassName    chapter5-FemaleHealthForm
 * Description  女性体检表
 *
 * @author      xuanc
 * @date        19-5-2 下午5:21
 * @version     1.0
 */ 
public class FemaleHealthForm extends HealthForm {

    private String uterus;

    public void setUterus(String uterus) {
        this.uterus = uterus;
    }

    public String getUterus() {
        return uterus;
    }
}
