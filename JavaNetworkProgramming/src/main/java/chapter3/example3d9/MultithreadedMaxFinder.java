package chapter3.example3d9;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author      xuanc
 * @date        2019/12/7 下午4:23
 * @version     1.0
 */ 
public class MultithreadedMaxFinder {

    public static int max(int[] data) throws InterruptedException, ExecutionException {
        if (data.length == 1) {
            return data[0];
        } else if (data.length == 0) {
            throw new IllegalArgumentException();
        }

        // 将任务分解成两个部分
        FindMaxTask task1 = new FindMaxTask(data, 0, data.length / 2);
        FindMaxTask task2 = new FindMaxTask(data, data.length / 2, data.length);

        // 创建两个线程
        ExecutorService service = Executors.newFixedThreadPool(2);

        Future<Integer> future1 = service.submit(task1);
        Future<Integer> future2 = service.submit(task2);

        return Math.max(future1.get(), future2.get());
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println(max(new int[] {1, 2, 3, 5, 8, 4}));
        new LinkedList<Integer>().toArray();
    }

}
