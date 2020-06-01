package demo;

/**
 * @author      xuanc
 * @date        2020/2/20 下午5:22
 * @version     1.0
 */ 
public class ThreadStateDemoWait {

    public static void main(String[] args) throws InterruptedException {
        Object obj = new Object();
        Thread t1 = new Thread(() -> {
           synchronized (obj) {
               try {
                   System.out.println("t1 wait(3000L)");
                   obj.wait(3000L);
                   System.out.println("t1 wait()");
                   obj.wait();
                   System.out.println("t1 执行完");
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
        });

        t1.start();

        Thread.sleep(1000L);

        synchronized (obj) {
            System.out.println("t1: " + t1.getState());
            obj.notify();
            Thread.sleep(1000L);
            System.out.println("t1: " + t1.getState());
        }

        Thread.sleep(3000L);
        System.out.println("t1: " + t1.getState());

        Thread.sleep(1000L);
        synchronized (obj) {
            obj.notify();
        }

        System.out.println("t1: " + t1.getState());
        Thread.sleep(1000L);
        System.out.println("t1: " + t1.getState());

    }

}
