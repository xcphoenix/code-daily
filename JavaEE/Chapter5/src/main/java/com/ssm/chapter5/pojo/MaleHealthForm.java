package com.ssm.chapter5.pojo;

/**
 * ClassName    chapter5-MaleHealthForm
 * Description  男性体检表
 *
 * @author      xuanc
 * @date        19-5-2 下午5:22
 * @version     1.0
 */ 
public class MaleHealthForm extends HealthForm {

    private String prostate;

    public void setProstate(String prostate) {
        this.prostate = prostate;
    }

    public String getProstate() {
        return prostate;
    }
}
