package proxy.cglibproxy;

/**
 * @author      xuanc
 * @date        2020/2/14 下午10:38
 * @version     1.0
 */ 
public class Main {

    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory(new Demo());
        Demo demo = (Demo) proxyFactory.getProxyInstance();
        demo.save();
    }

}
