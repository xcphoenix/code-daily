package myrunable;

/**
 * @author      xuanc
 * @date        2019/11/17 下午5:51
 * @version     1.0
 */ 
public class Run {
    public static void main(String[] args) {
        Runnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable);
        thread.start();
        System.out.println("运行结束");
    }
}
