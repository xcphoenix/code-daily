package com.lean.ssm.chapter2.reflect;

import java.lang.reflect.InvocationTargetException;

/**
 * ClassName    Chapter2-ReflectServiceImpl2
 * Description  
 *
 * @author      xuanc
 * @date        19-4-25 下午12:04
 * @version     1.0
 */ 
public class ReflectServiceImpl2 {

    private String name;

    public ReflectServiceImpl2(String name) {
        this.name = name;
    }

    public void sayHello() {
        System.out.println("hello " + name);
    }

    public ReflectServiceImpl2 getInstance() {
        ReflectServiceImpl2 object = null;
        try {
            object = (ReflectServiceImpl2)
                    Class.forName("com.lean.ssm.chapter2.reflect.ReflectServiceImpl2")
                            .getConstructor(String.class)
                            .newInstance("张三");
        } catch (ClassNotFoundException | InstantiationException
                | IllegalAccessException | NoSuchMethodException
                | SecurityException | IllegalArgumentException
                | InvocationTargetException ex) {
            ex.printStackTrace();
        }
        return object;
    }



}
