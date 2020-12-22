package test;


import mythread.MyThread;

/**
 * @author xuanc
 * @version 1.0
 * @date 2019/11/17 下午5:28
 */
public class OneTest {
    public static void main(String[] args) {
        try {
            MyThread thread = new MyThread();
            thread.setName("myThread");
            thread.start();
            // thread.run();
            for (int i = 0; i < 10; i++) {
                int time = (int) (Math.random() * 1000);
                Thread.sleep(time);
                System.out.println("main=" + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
