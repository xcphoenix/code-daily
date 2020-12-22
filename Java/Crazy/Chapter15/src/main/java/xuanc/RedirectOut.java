package xuanc;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * ClassName    Chapter15-RedirectOut
 * Description  重定向标准输入、输出
 *
 * @author xuanc
 * @version 1.0
 * @date 19-4-10 下午5:00
 */
public class RedirectOut {

    public static void main(String[] args) {
        try (
                // 一次性创建 PrintStream 输出流
                PrintStream ps = new PrintStream(new FileOutputStream("out.txt"))
        ) {
            // 将标准输出重定向到ps输出流
            System.setOut(ps);
            // 向标准输出输出一个字符串
            System.out.println("普通字符串");
            System.out.println(new RedirectOut());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
