package demo;

import java.util.concurrent.locks.LockSupport;

/**
 * @author      xuanc
 * @date        2020/2/20 下午5:48
 * @version     1.0
 */ 
public class ThreadStateDemoPark {

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            LockSupport.park();
        });

        t1.start();

        Thread.sleep(2000L);

        System.out.println(t1.getState());

        LockSupport.unpark(t1);

    }

}
