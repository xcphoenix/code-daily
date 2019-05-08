package com.ssm.chapter5.pojo;

/**
 * ClassName    chapter5-Task
 * Description  任务表
 *
 * @author      xuanc
 * @date        19-5-2 下午5:29
 * @version     1.0
 */ 
public class Task {

    private Long id;
    private String title;
    private String context;
    private String note;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
