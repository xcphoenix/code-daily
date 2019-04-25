package com.lean.ssm.chapter2.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * ClassName    Chapter2-ReflectServiceImpl
 * Description  
 *
 * @author      xuanc
 * @date        19-4-25 上午11:55
 * @version     1.0
 */ 
public class ReflectServiceImpl {
    public void sayHello(String name) {
        System.out.println("Hello " + name);
    }

    /**
     * 通过反射来构建对象
     * @return ReflectServiceImpl
     */
    public ReflectServiceImpl getInstance() {
        ReflectServiceImpl object = null;
        try {
            object = (ReflectServiceImpl)
                    /*
                     * 给类加载器注册了一个类的全限定名
                     */
                    Class.forName("com.lean.ssm.chapter2.reflect.ReflectServiceImpl")
                    /*
                     * 通过 newInstance 方法初始化一个类对象
                     */
                    .newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            ex.printStackTrace();
        }
        return object;
    }

    /**
     * 获取和反射方法
     * @return 获取的方法对象
     */
    public Object reflectMethod() {
        Object returnObj = null;
        ReflectServiceImpl target = new ReflectServiceImpl();
        try {
            Method method = ReflectServiceImpl.class.getMethod("sayHello", String.class);
            returnObj = method.invoke(target, "张三");
        } catch(NoSuchMethodException | SecurityException
            | IllegalAccessException | IllegalArgumentException
            | InvocationTargetException ex) {
            ex.printStackTrace();
        }
        return returnObj;
    }

    /**
     * 反射生成对象和反射调度方法
     * @return
     */
    public Object reflect() {
        ReflectServiceImpl object = null;
        try {
            object = (ReflectServiceImpl)
                    Class.forName("com.lean.ssm.chapter2.reflect.ReflectServiceImpl")
                    .newInstance();
            Method method = object.getClass().getMethod("sayHello", String.class);
            method.invoke(object, "张三");
        } catch (NoSuchMethodException | SecurityException
            | ClassNotFoundException | IllegalAccessException
            | IllegalArgumentException | InvocationTargetException
            | InstantiationException ex) {
            ex.printStackTrace();
        }
        return object;
    }
}
