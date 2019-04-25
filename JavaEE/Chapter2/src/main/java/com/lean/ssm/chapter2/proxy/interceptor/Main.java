package com.lean.ssm.chapter2.proxy.interceptor;

import com.lean.ssm.chapter2.proxy.jdk.HelloWorld;
import com.lean.ssm.chapter2.proxy.jdk.HelloWorldImp1;

/**
 * ClassName    Chapter2-Main
 * Description  
 *
 * @author      xuanc
 * @date        19-4-25 下午4:08
 * @version     1.0
 */ 
public class Main {
    public static void main(String[] args) {
        HelloWorld proxy = (HelloWorld)InterceptorJdkProxy.bind(new HelloWorldImp1(),
                "com.lean.ssm.chapter2.proxy.interceptor.MyInterceptor");
        proxy.sayHelloWorld();
    }
}
