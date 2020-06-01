package com.ssm.chapter5.pojo;

/**
 * ClassName    chapter5-EmployeeTask
 * Description  雇员任务表
 *
 * @author      xuanc
 * @date        19-5-12 上午10:28
 * @version     1.0
 */ 
public class EmployeeTask {

    private Long id;
    private Long empId;
    private Task task = null;
    private String taskName;
    private String note;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
