package demo;

import java.util.concurrent.*;

/**
 * @author      xuanc
 * @date        2020/2/21 下午5:40
 * @version     1.0
 */ 
public class FutureTaskDemo {

    static int i = 0;

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<Void> future = executorService.submit(() -> {
            while (true) {
                i++;
            }
        }, null);

        System.out.println(future.getClass());

        try {
            future.get(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

        System.out.println(i);

    }

}
