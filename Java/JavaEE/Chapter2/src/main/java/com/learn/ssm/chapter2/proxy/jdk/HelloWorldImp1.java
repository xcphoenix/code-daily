package com.learn.ssm.chapter2.proxy.jdk;

/**
 * ClassName    Chapter2-HelloWorldImp1
 * Description  
 *
 * @author      xuanc
 * @date        19-4-25 下午1:50
 * @version     1.0
 */ 
public class HelloWorldImp1 implements HelloWorld {
    @Override
    public void sayHelloWorld() {
        System.out.println("Hello World");
    }
}
