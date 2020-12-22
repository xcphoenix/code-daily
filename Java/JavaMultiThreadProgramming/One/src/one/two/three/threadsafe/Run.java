package one.two.three.threadsafe;

import one.two.three.threadsafe.extthread.ALogin;
import one.two.three.threadsafe.extthread.BLogin;

/**
 * @author      xuanc
 * @date        2019/11/17 下午7:09
 * @version     1.0
 */ 
public class Run {
    public static void main(String[] args) {
        ALogin a = new ALogin();
        a.start();
        BLogin b = new BLogin();
        b.start();
    }
}
