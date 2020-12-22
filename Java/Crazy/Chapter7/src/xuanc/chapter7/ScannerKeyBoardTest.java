package xuanc.chapter7;

import java.util.Scanner;

/**
 * ClassName    Chapter7-ScannerKeyBoardTest
 * Description  使用 Scanner 获取键盘输入
 *
 * @author xuanc
 * @version 1.0
 * @date 19-3-29 下午9:38
 */
public class ScannerKeyBoardTest {
    public static void main(String[] args) {
        // System.in 代表标准输入（即键盘输入）
        Scanner sc = new Scanner(System.in);
        // 增加下面一行只把回车作为分隔符
        sc.useDelimiter("\n");
        // 判断是否还有下一个输入项
        while (sc.hasNext()) {
            // 输入输入项
            System.out.println("键盘输入的内容是: " + sc.next());
        }
    }
}
