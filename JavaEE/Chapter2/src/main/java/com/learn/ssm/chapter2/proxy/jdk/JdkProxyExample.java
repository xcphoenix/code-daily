package com.learn.ssm.chapter2.proxy.jdk;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * ClassName    Chapter2-JdkProxyExample
 * Description  
 *
 * @author      xuanc
 * @date        19-4-25 下午1:51
 * @version     1.0
 */ 
public class JdkProxyExample implements InvocationHandler {

    /**
     * 保存真实对象
     */
    private Object target = null;

    /**
     * 建立代理对象和真实对象的代理关系，并返回代理对象
     * @param target 真实对象
     * @return 代理对象
     */
    public Object bind(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    /**
     * 代理方法逻辑
     * @param proxy 代理对象
     * @param method 当前调度方法
     * @param args 当前方法参数
     * @return 代理结果返回
     * @throws Throwable 异常
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("进入代理逻辑方法");
        System.out.println("在调度真实对象之前的服务");
        // 相当于调用 sayHelloWorld 方法
        Object obj = method.invoke(target, args);
        System.out.println("在调度真实对象之后的服务");
        return obj;
    }

    /**
     * 测试JDK动态代理
     */
    @Test
    public void testJdkProxy() throws Throwable {
        JdkProxyExample jdk = new JdkProxyExample();
        // 绑定关系，因为挂在接口 HelloWorld 下，所以声明代理对象 HelloWorld proxy
        HelloWorld proxy = (HelloWorld)jdk.bind(new HelloWorldImp1());
        // proxy 是一个代理对象，会进入代理的逻辑方法 invoke()
        proxy.sayHelloWorld();
        jdk.invoke(proxy, HelloWorldImp1.class.getMethod("sayHelloWorld"), null);
    }
}
