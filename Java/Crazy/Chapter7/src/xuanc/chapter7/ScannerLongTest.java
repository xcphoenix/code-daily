package xuanc.chapter7;

import java.util.Scanner;

/**
 * ClassName    Chapter7-ScannerLongTest
 * Description  Scanner Test
 *
 * @author xuanc
 * @version 1.0
 * @date 19-3-29 下午9:45
 */
public class ScannerLongTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLong()) {
            System.out.println("键盘输入的是：" + sc.nextLong());
        }
    }

}
