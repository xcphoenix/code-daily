package one.two.three;

/**
 * @author      xuanc
 * @date        2019/11/17 下午6:36
 * @version     1.0
 */ 
public class Run1 {
    public static void main(String[] args) {
        MyThread1 myThread = new MyThread1();
        Thread a = new Thread(myThread, "A");
        Thread b = new Thread(myThread, "B");
        Thread c = new Thread(myThread, "C");
        Thread d = new Thread(myThread, "D");
        Thread e = new Thread(myThread, "E");
        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
    }
}
