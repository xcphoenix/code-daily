package singleton;

/**
 * 双重检测
 *
 * @author      xuanc
 * @date        2020/2/17 下午5:32
 * @version     1.0
 */ 
public class LazySingletonCheckTwice {

    private LazySingletonCheckTwice() {}

    private static LazySingletonCheckTwice instance = null;
    // 防止指令重排
    // private static volatile LazySingletonCheckTwice instance = null;

    public static LazySingletonCheckTwice getInstance() {
        // 第一重判断
        if (instance == null) {
            // 使用锁机制
            synchronized (LazySingletonCheckTwice.class) {
                // 第二重判断
                if (instance == null) {
                    instance = new LazySingletonCheckTwice();
                }
            }
        }
        return instance;
    }

}
