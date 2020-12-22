package one.two.three.threadsafe.extthread;

import one.two.three.threadsafe.controller.LoginServlet;

/**
 * @author      xuanc
 * @date        2019/11/17 下午7:08
 * @version     1.0
 */ 
public class ALogin extends Thread {

    @Override
    public void run() {
        LoginServlet.doPost("a", "aa");
    }
}
