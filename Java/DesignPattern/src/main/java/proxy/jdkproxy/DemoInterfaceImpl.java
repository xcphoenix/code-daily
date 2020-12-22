package proxy.jdkproxy;

import java.awt.*;

/**
 * @author      xuanc
 * @date        2020/2/14 下午9:59
 * @version     1.0
 */ 
public class DemoInterfaceImpl implements DemoInterface {

    private String msg;

    public DemoInterfaceImpl(String msg) {
        this.msg = msg;
    }

    @Override
    public void echo() {
        System.out.println(msg);
    }

    public void echoReverse() {
        System.out.println(new StringBuilder(msg).reverse());
    }

}
