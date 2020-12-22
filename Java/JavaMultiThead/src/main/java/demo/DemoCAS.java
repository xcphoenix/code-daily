package demo;

/**
 * @author      xuanc
 * @date        2020/2/20 下午9:54
 * @version     1.0
 */ 
public class DemoCAS {

    static volatile int t = 1;
    static volatile int i = 0;

    public static void main(String[] args) {
        new Thread(() -> {
           while (i < 10) {
               while (t != 1) {
               }
               System.out.println("t1: " + (++i));
               t = 2;
           }
        }).start();

        new Thread(() -> {
            while (i < 10) {
                while (t != 2) {
                }
                System.out.println("t2: " + (++i));
                t = 3;
            }
        }).start();

        new Thread(() -> {
            while (i < 10) {
                while (t != 3) {
                }
                System.out.println("t3: " + (++i));
                t = 1;
            }
        }).start();

    }

}
