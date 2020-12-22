package demo;

/**
 * @author      xuanc
 * @date        2020/2/20 下午5:17
 * @version     1.0
 */ 
public class ThreadStateDemoSynchronized {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {
            synchronized (ThreadStateDemoSynchronized.class) {
                System.out.println("t1 抢到锁");
            }
        });

        synchronized (ThreadStateDemoSynchronized.class) {
            thread.start();
            Thread.sleep(1000L);
            System.out.println("t1 抢不到锁的状态：" + thread.getState());
        }

    }

}
