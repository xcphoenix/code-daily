package com.learn.ssm.chapter2.proxy.interceptor;

import java.lang.reflect.Method;

/**
 * ClassName    Chapter2-Interceptor
 * Description  定义拦截器接口
 *
 * @author      xuanc
 * @date        19-4-25 下午3:35
 * @version     1.0
 */ 
public interface Interceptor {
    public boolean before(Object proxy, Object target, Method method, Object[] args);
    public void around(Object proxy, Object target, Method method, Object[] args);
    public void after(Object proxy, Object target, Method method, Object[] args);
}
