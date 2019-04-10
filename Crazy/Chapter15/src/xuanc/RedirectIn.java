package xuanc;

import java.io.*;
import java.util.Scanner;

/**
 * ClassName    Chapter15-RedirectIn
 * Description
 *
 * @author xuanc
 * @version 1.0
 * @date 19-4-10 下午5:04
 */
public class RedirectIn {

    public static void main(String[] args) {
        try (
                FileInputStream fis = new FileInputStream("src/xuanc/RedirectIn.java");
        ) {
            System.setIn(fis);
            Scanner sc = new Scanner(System.in);
            // 使用回车作为分隔符
            sc.useDelimiter("\n");

            while (sc.hasNext()) {
                System.out.println("键盘输入的内容是：" + sc.next());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
