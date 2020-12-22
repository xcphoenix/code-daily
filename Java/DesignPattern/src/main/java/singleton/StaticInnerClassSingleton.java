package singleton;

/**
 * @author      xuanc
 * @date        2020/2/17 下午6:01
 * @version     1.0
 */ 
public class StaticInnerClassSingleton {

    private static boolean first = true;

    private StaticInnerClassSingleton() {
        synchronized (StaticInnerClassSingleton.class) {
            if (first) {
                first = false;
            } else {
                throw new RuntimeException("单例对象已存在");
            }
        }
    }

    private static class LazyHolder {
        private static final StaticInnerClassSingleton INSTANCE = new StaticInnerClassSingleton();
    }

    public static StaticInnerClassSingleton getInstance() {
        return LazyHolder.INSTANCE;
    }

}
