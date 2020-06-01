package com.learn.ssm.chapter2.proxy.cglib;

import com.learn.ssm.chapter2.reflect.ReflectServiceImpl;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

/**
 * ClassName    Chapter2-CglibProxyExample
 * Description  cglib 动态代理
 *
 * @author      xuanc
 * @date        19-4-25 下午2:35
 * @version     1.0
 */ 
public class CglibProxyExample implements MethodInterceptor {

    /**
     * 生成 CGLIB 代理对象
     * @param cls Class 类
     * @return Class 类的 CGLIB 对象
     */
    public Object getProxy(Class cls) {
        // CGLIB enhancer 代理对象
        Enhancer enhancer = new Enhancer();
        // 设置增强类型
        enhancer.setSuperclass(cls);
        // 定义逻辑对象为当前的对象，要求当前对象实现 MethodInterceptor 方法
        enhancer.setCallback(this);
        return enhancer.create();
    }

    /**
     * 代理逻辑方法
     * @param o　代理对象
     * @param method　方法
     * @param objects　方法参数
     * @param methodProxy　方法代理
     * @throws Throwable　异常
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("调用真实对象前");
        // CGLIB 反射调用真实对象方法
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("调用真实对象后");
        return result;
    }

    @Test
    public void testCGLIBProxy() {
        CglibProxyExample cpe = new CglibProxyExample();
        ReflectServiceImpl obj = (ReflectServiceImpl)cpe.getProxy(ReflectServiceImpl.class);
        obj.sayHello("张三");
    }
}
