package singleton;

/**
 * @author      xuanc
 * @date        2020/2/17 下午5:23
 * @version     1.0
 */ 
public class HungrySingleton {

    private HungrySingleton() {}

    private static HungrySingleton singleton = new HungrySingleton();

    public static HungrySingleton getInstance() {
        return singleton;
    }

}
