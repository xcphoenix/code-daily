package com.learn.ssm.chapter2.responsibility;

import com.learn.ssm.chapter2.proxy.interceptor.InterceptorJdkProxy;
import com.learn.ssm.chapter2.proxy.jdk.HelloWorld;
import com.learn.ssm.chapter2.proxy.jdk.HelloWorldImp1;

/**
 * ClassName    Chapter2-Main
 * Description  
 *
 * @author      xuanc
 * @date        19-4-25 下午4:33
 * @version     1.0
 */ 
public class Main {

    public static void main(String[] args) {
        HelloWorld proxy1 = (HelloWorld) InterceptorJdkProxy.bind(new HelloWorldImp1(),
                "Interceptor1");
        HelloWorld proxy2 = (HelloWorld) InterceptorJdkProxy.bind(proxy1,
                "Interceptor2");
        HelloWorld proxy3 = (HelloWorld) InterceptorJdkProxy.bind(proxy2,
                "Interceptor3");
        proxy3.sayHelloWorld();
    }

}
