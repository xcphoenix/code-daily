package demo;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author xuanc
 * @version 1.0
 * @date 2020/3/8 下午9:44
 */
public class CallableTest {

    static class ThreadDemo extends Thread {
        @Override
        public void run() {
            System.out.println("run!");
        }
    }

    public static void main(String[] args) {
        // Callable<Void> callable = () -> {
        //     System.out.println("run!");
        //     try {
        //         Thread.sleep(4000);
        //     } catch (InterruptedException ex) {
        //         ex.printStackTrace();
        //     }
        //     System.out.println("end!");
        //     return null;
        // };
        // Future<Void> future = Executors.newFixedThreadPool(1).submit(callable);
        // System.out.println("Main run");
        // try {
        //     future.get();
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }
        // System.out.println("Main end");
        new ThreadDemo().start();
        System.out.println("main end");
    }

}
