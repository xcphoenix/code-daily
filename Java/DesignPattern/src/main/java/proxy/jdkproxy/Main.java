package proxy.jdkproxy;

/**
 * @author      xuanc
 * @date        2020/2/14 下午9:50
 * @version     1.0
 */ 
public class Main {

    public static void main(String[] args) {
        Demo demo = new Demo();
        Object proxy = new ProxyFactory(demo).getProxyInstance();
        System.out.println(proxy.getClass());

        DemoInterface demoInterface = new DemoInterfaceImpl("demo");
        DemoInterface demoInterfaceProxy = (DemoInterface) new ProxyFactory(demoInterface).getProxyInstance();
        demoInterfaceProxy.echo();

    }

}
