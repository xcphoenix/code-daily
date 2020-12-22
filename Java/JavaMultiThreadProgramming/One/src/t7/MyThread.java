package t7;

/**
 * @author      xuanc
 * @date        2019/11/18 下午7:32
 * @version     1.0
 */ 
public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("run=" + this.isAlive());
    }
}
