package one.two.three;

/**
 * @author      xuanc
 * @date        2019/11/17 下午6:32
 * @version     1.0
 */ 
public class MyThread1 extends Thread {
    private int count = 5;

    @Override
    synchronized public void run() {
        super.run();
        count--;
        System.out.println("由 " + currentThread().getName() + " 计算，count = " + count);
    }
}
