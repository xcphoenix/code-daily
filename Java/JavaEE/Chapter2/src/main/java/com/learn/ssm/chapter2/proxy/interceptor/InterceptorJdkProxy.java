package com.learn.ssm.chapter2.proxy.interceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * ClassName    Chapter2-InterceptorJdkProxy
 * Description  
 *
 * @author      xuanc
 * @date        19-4-25 下午3:41
 * @version     1.0
 */ 
public class InterceptorJdkProxy implements InvocationHandler {

    /**
     * 真实对象
     */
    private Object target;
    /**
     * 拦截器全限定名
     */
    private String interceptorClass = null;

    public InterceptorJdkProxy(Object target, String interceptorClass) {
        this.target = target;
        this.interceptorClass = interceptorClass;
    }

    public static Object bind(Object target, String interceptorClass) {
        // 取代代理对象
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), new InterceptorJdkProxy(target, interceptorClass));
    }

    /**
     * 通过代理对象调用方法，首先进入这个方法
     * @param proxy　代理对象
     * @param method　方法，被调用方法
     * @param args　方法的参数
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (interceptorClass == null) {
            // 没有设置拦截器则直接反射原有方法
            return method.invoke(target, args);
        }
        Object result = null;
        // 通过反射生成拦截器
        Interceptor interceptor = (Interceptor)Class.forName(interceptorClass).newInstance();
        // 调用前置方法
        if (interceptor.before(proxy, target, method, args)) {
            result = method.invoke(target, args);
        } else {
            interceptor.around(proxy, target, method, args);
        }
        interceptor.after(proxy, target, method, args);
        return result;
    }

}
