package demo;

import java.util.UUID;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xuanc
 * @version 1.0
 * @date 2020/3/9 上午9:41
 */
public class BoundedBuffer {

    final Lock lock = new ReentrantLock();
    final Condition notFull = lock.newCondition();
    final Condition notEmpty = lock.newCondition();

    final Object[] items = new Object[100];
    int putPtr, takePtr, count;

    // produce
    public void put(Object x) throws InterruptedException {
        lock.lock();
        try {
            System.out.println("produce...");
            while (count == items.length) {
                System.out.println("buffer full, wait consume");
                notFull.await();
            }
            System.out.println("produce success");
            items[putPtr] = x;
            if (++putPtr == items.length) {
                putPtr = 0;
            }
            count++;
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public Object take() throws InterruptedException {
        lock.lock();
        try {
            System.out.println("consuming...");
            while (count == 0) {
                System.out.println("buffer empty, wait produce");
                notEmpty.await();
            }
            System.out.println("consume success");
            Object x = items[takePtr];
            if (++takePtr == items.length) {
                takePtr = 0;
            }
            count--;
            notFull.signal();
            return x;
        } finally {
            lock.unlock();
        }
    }

    private static BoundedBuffer boundedBuffer = new BoundedBuffer();

    public static void main(String[] args) {
        new Thread(() -> {
            int maxVal = 400;
            int count = 0;
            while (count < maxVal) {
                String str = UUID.randomUUID().toString();
                try {
                    boundedBuffer.put(str);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count++;
            }
        }).start();

        new Thread(() -> {
            int maxVal = 400;
            int count = 0;
            while (count < maxVal) {
                try {
                    Object obj = boundedBuffer.take();
                    System.out.println("Obj => " + obj);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count++;
            }
        }).start();
    }

}
