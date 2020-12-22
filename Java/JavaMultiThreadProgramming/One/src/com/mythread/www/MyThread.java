package com.mythread.www;

/**
 * @author      xuanc
 * @date        2019/11/17 下午5:11
 * @version     1.0
 */ 
public class MyThread extends Thread {
    @Override
    public void run() {
        super.run();
        System.out.println("MyThread");
    }
}
