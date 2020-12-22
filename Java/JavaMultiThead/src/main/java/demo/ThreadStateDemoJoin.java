package demo;

/**
 * @author      xuanc
 * @date        2020/2/20 下午5:09
 * @version     1.0
 */ 
public class ThreadStateDemoJoin {

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
           try {
               Thread.sleep(10000L);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
        });

        Thread t2 = new Thread(() -> {
           try {
               System.out.println("t2 执行 t1.join(5000L)");
               t1.join(5000L);
               System.out.println("t2 中执行 t1.join()");
               t1.join();
               System.out.println("t2 执行完");
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
        });

        t1.start();
        t2.start();

        Thread.sleep(1000L);
        System.out.println("t2: " + t2.getState());

        Thread.sleep(5000L);
        System.out.println("t2: " + t2.getState());

    }

}
