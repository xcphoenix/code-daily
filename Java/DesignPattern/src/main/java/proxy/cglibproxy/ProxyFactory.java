package proxy.cglibproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Cglib 必须实现 MethodInterceptor 方法拦截器接口
 *
 * @author      xuanc
 * @date        2020/2/14 下午10:23
 * @version     1.0
 */ 
public class ProxyFactory implements MethodInterceptor {

    /**
     * 目标对象
     */
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
        System.out.println("target: " + target);
    }

    /**
     * 为目标对象创建代理对象
     */
    public Object getProxyInstance() {
        // 增强器
        Enhancer en = new Enhancer();
        // 设置父类
        en.setSuperclass(target.getClass());
        // 设置回调对象
        en.setCallback(this);
        // 创建类
        return en.create();
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("obj: " + obj.getClass());
        System.out.println("method: " + method.getDeclaringClass() + " -> " + method.getName());
        System.out.println("args: " + Arrays.toString(args));
        System.out.println("methodProxy: " + proxy.getClass());

        System.out.println("\nbegin");
        Object returnValue = method.invoke(target, args);
        System.out.println("end");
        return returnValue;
    }

}
