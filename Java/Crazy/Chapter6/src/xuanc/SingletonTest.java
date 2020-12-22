package xuanc;

class Singleton {
    /**
     * 使用类变量来缓存曾经创建的实例
     */
    private static Singleton instance;
    /**
     * 使用 private，隐藏该构造器
     */
    private Singleton() {}

    /**
     * 提供一个静态方法，用于返回 Singleton 实例
     * @return Singleton 对象
     */
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

/**
 * ClassName    Chapter6-SingletonTest
 * Description  测试单例类
 *
 * @author xuanc
 * @version 1.0
 * @date 19-3-23 下午2:14
 */
public class SingletonTest {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println((s1 == s2) + " " + s1 + s2);
    }
}
