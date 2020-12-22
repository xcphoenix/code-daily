package singleton;

/**
 * 单例模式： 懒汉模式
 *
 * @author      xuanc
 * @date        2020/2/17 下午5:16
 * @version     1.0
 */ 
public class LazySingleton {

    /**
     * 私有构造函数
     */
    private LazySingleton() {}

    private static LazySingleton instance = null;

    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }

}
