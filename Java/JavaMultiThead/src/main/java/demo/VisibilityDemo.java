package demo;

import java.util.concurrent.TimeUnit;

/**
 * @author      xuanc
 * @date        2020/2/20 下午10:06
 * @version     1.0
 */ 
public class VisibilityDemo {

    private static volatile boolean is = true;

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (VisibilityDemo.is) {
                    // synchronized (this) {
                    //     i++;
                    // }
                    i++;
                }
                System.out.println(i);
            }
        }).start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        VisibilityDemo.is = false;
        System.out.println("end!");

    }

}
