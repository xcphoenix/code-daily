package com.mythread.www;

/**
 * @author      xuanc
 * @date        2019/11/17 下午5:16
 * @version     1.0
 */ 
public class Run {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        System.out.println("运行结束");
        // myThread.run();
        // myThread.run();
    }
}