package demo;

import java.util.concurrent.locks.LockSupport;

/**
 * @author      xuanc
 * @date        2020/2/20 下午9:12
 * @version     1.0
 */ 
public class DemoLockSupport {

    static Thread t1, t2, t3;
    static int i = 0;

    public static void main(String[] args) {

        t1 = new Thread(() -> {
            while(i < 10) {
                System.out.println("t1: " + (++i));
                LockSupport.unpark(t2);
                LockSupport.park();
            }
        });

        t2 = new Thread(() -> {
           while (i < 10) {
               LockSupport.park();
               System.out.println("t2: " + (++i));
               LockSupport.unpark(t3);
           }
        });

        t3 = new Thread(() -> {
            while (i < 10) {
                LockSupport.park();
                System.out.println("t3: " + (++i));
                LockSupport.unpark(t1);
            }
        });

        t3.start();
        t2.start();
        t1.start();

    }

}
