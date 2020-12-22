package one.two.three;

/**
 * @author      xuanc
 * @date        2019/11/17 下午5:54
 * @version     1.0
 */ 
public class MyThread extends Thread {
    private int count = 5;
    public MyThread(String name) {
        super();
        this.setName(name);
    }

    @Override
    public void run() {
        super.run();
        while (count > 0) {
            count--;
            System.out.println("由 " + currentThread().getName() + "计算, count = " + count);
        }
    }
}
