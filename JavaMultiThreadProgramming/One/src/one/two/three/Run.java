package one.two.three;

/**
 * @author      xuanc
 * @date        2019/11/17 下午6:21
 * @version     1.0
 */ 
public class Run {
    public static void main(String[] args) {
        MyThread a = new MyThread("A");
        MyThread b = new MyThread("B");
        MyThread c = new MyThread("C");
        a.start();
        b.start();
        c.start();
    }
}
