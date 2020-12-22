import top.xcphoenix.algorithm.sort.HeapSort;

import java.util.Arrays;
import java.util.concurrent.*;

/**
 * @author xuanc
 * @version 1.0
 * @date 2020/4/6 上午10:22
 */
public class Demo {

    static class Run implements Runnable {

        @Override
        public void run() {
            System.out.println("run");
            throw new RuntimeException("run throw");
        }

    }

    static class Call implements Callable<String> {
        @Override
        public String call() throws Exception {
            Thread.sleep(2000);
            throw new RuntimeException("call exception");
        }
    }

    public static void main(String[] args) throws Exception {
        // new Thread(new Run()).start();
        Call call = new Call();
        Future<String> future = Executors.newFixedThreadPool(10).submit(call);
        // System.out.println("err: " + future.get());
    }

}
