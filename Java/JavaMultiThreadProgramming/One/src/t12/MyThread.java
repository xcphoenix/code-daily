package t12;

/**
 * @author      xuanc
 * @date        2019/11/20 上午11:25
 * @version     1.0
 */ 
public class MyThread extends Thread {
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 50000; i++) {
            System.out.println("i = " + (i + 1));
        }
    }
}
