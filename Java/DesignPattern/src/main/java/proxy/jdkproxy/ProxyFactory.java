package proxy.jdkproxy;

import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * 创建动态代理对象
 * 动态代理对象不需要实现接口，但是需要指定接口类型
 *
 * @author      xuanc
 * @date        2020/2/14 下午9:43
 * @version     1.0
 */ 
public class ProxyFactory {

    /**
     * 目标对象
     */
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    /**
     * 为目标对象生成代理对象
     */
    public Object getProxyInstance() {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    System.out.println("proxy: " + proxy.getClass());
                    System.out.println("method: " + method.getDeclaringClass() + " -> " + method.getName());
                    System.out.println("args: " + Arrays.toString(args));

                    System.out.println("开始事务2");
                    Object returnValue = method.invoke(target, args);
                    System.out.println("提交事务2");
                    return returnValue;
                }
        );
    }

}
