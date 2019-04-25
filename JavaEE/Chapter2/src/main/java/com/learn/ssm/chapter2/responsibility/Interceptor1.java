package com.learn.ssm.chapter2.responsibility;

import com.learn.ssm.chapter2.proxy.interceptor.Interceptor;

import java.lang.reflect.Method;

/**
 * ClassName    Chapter2-Interceptor1
 * Description  责任链拦截器接口定义
 *
 * @author      xuanc
 * @date        19-4-25 下午4:24
 * @version     1.0
 */ 
public class Interceptor1 implements Interceptor {

    @Override
    public boolean before(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("【拦截器1】的 before 方法");
        return true;
    }

    @Override
    public void around(Object proxy, Object target, Method method, Object[] args) {

    }

    @Override
    public void after(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("【拦截器2】的 after 方法");
    }

}
