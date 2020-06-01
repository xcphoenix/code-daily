package one.two.four.extthread;

/**
 * @author      xuanc
 * @date        2019/11/17 下午7:14
 * @version     1.0
 */ 
public class MyThread extends Thread {
    private int i = 5;

    @Override
    public void run() {
        System.out.println("i=" + (i--) + " threadName=" + Thread.currentThread().getName());
    }
}
