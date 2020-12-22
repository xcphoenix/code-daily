package demo;

/**
 * TODO jdk12 t1 拿不到锁？？
 *
 * @author xuanc
 * @version 1.0
 * @date 2020/2/20 下午5:54
 */
public class Demo {

    static int num = 0;
    static Object obj = new Object();

    public static void main(String[] args) {

        class Run implements Runnable {

            private int value;

            public Run(int value) {
                this.value = value;
            }

            @Override
            public void run() {
                synchronized (obj) {
                    while (num < 10) {
                        if (num % 3 == value) {
                            System.out.println(Thread.currentThread().getName() + ": " + ++num);
                        }
                        obj.notifyAll();
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    obj.notifyAll();
                    // 没有这个，会导致有线程一直处理 wait 状态
                }
            }
        }

        Thread t1 = new Thread(new Run(0));
        t1.setName("t1");
        t1.start();
        Thread t2 = new Thread(new Run(1));
        t2.setName("t2");
        t2.start();
        Thread t3 = new Thread(new Run(2));
        t3.setName("t3");
        t3.start();
    }

}
