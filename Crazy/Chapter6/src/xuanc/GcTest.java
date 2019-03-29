package xuanc;

/**
 * ClassName    Chapter6-GcTest
 * Description  TODO
 *
 * @author xuanc
 * @version 1.0
 * @date 19-3-28 下午10:05
 */
public class GcTest {

    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            new GcTest();
            // 强制系统（然而只是通知罢了）进行垃圾回收
            // System.gc();
            Runtime.getRuntime().gc();
        }
    }
}
