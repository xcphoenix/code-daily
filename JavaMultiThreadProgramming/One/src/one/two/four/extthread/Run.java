package one.two.four.extthread;

/**
 * @author      xuanc
 * @date        2019/11/17 下午7:16
 * @version     1.0
 */ 
public class Run {
    public static void main(String[] args) {
        MyThread run = new MyThread();
        Thread t1 = new Thread(run);
        Thread t2 = new Thread(run);
        Thread t3 = new Thread(run);
        Thread t4 = new Thread(run);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
