package xuanc;

class Apple {
    @Deprecated(since = "9", forRemoval = true)
    public void info() {
        System.out.println("Apple 的　info 方法");
    }
}

/**
 * ClassName    Chapter14-DeprecatedTest
 * Description  Java 9 增强的 @Deprecated 注解
 *
 * @author xuanc
 * @version 1.0
 * @date 19-4-1 下午10:10
 */
public class DeprecatedTest {

    public static void main(String[] args) {
        new Apple().info();
    }

}
