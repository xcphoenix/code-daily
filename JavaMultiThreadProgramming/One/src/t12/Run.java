package t12;

/**
 * @author      xuanc
 * @date        2019/11/20 上午11:27
 * @version     1.0
 */ 
public class Run {
    public static void main(String[] args) {
        try {
            MyThread thread = new MyThread();
            thread.start();
            Thread.sleep(1000);
            thread.interrupt();
            // Thread.currentThread().interrupt();
            System.out.println("是否停止1 ?= " + thread.interrupted());
            System.out.println("是否停止2 ?= "  + thread.isInterrupted());
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }
        System.out.println("end");
    }
}
