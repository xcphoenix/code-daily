package t7.test;

/**
 * @author      xuanc
 * @date        2019/11/18 下午7:36
 * @version     1.0
 */ 
public class CountOperate extends Thread {

    public CountOperate() {
        System.out.println("CountOperate --- begin");
        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
        System.out.println("Thread.currentThread().isAlive() = " + Thread.currentThread().isAlive());
        System.out.println("this.getName() = " + this.getName());
        System.out.println("this.isAlive() = " + this.isAlive());
        System.out.println("CountOperate --- end");
    }

    @Override
    public void run() {
        super.run();
    }
}
