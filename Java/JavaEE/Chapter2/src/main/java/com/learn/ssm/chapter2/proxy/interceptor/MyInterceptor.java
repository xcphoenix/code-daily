package com.learn.ssm.chapter2.proxy.interceptor;

import java.lang.reflect.Method;

/**
 * ClassName    Chapter2-MyInterceptor
 * Description  
 *
 * @author      xuanc
 * @date        19-4-25 下午3:38
 * @version     1.0
 */ 
public class MyInterceptor implements Interceptor {

    @Override
    public boolean before(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("反射方法前逻辑");
        // 不反射被代理对象的原有方法
        return false;
    }

    @Override
    public void after(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("反射方法后逻辑");
    }

    @Override
    public void around(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("取代了被代理对象的方法");
    }
}
