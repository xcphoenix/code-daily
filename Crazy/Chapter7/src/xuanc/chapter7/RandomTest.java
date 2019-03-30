package xuanc.chapter7;

import java.util.Random;

/**
 * ClassName    Chapter7-RandomTest
 * Description  Random 类的使用
 *
 * @author xuanc
 * @version 1.0
 * @date 19-3-30 下午4:16
 */
public class RandomTest {

    public static void main(String[] args) {
        Random rand = new Random();
        System.out.println("rand.nextBoolean() ==> " + rand.nextBoolean());
        byte[] buffer = new byte[16];
        rand.nextBytes(buffer);
    }

}
