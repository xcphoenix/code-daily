package xuanc;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * ClassName    Chapter15-PrintStreamTest
 * Description
 *
 * @author xuanc
 * @version 1.0
 * @date 19-4-10 下午4:08
 */
public class PrintStreamTest {

    public static void main(String[] args) {
        try (
                FileOutputStream fos = new FileOutputStream("test.txt");
                PrintStream ps = new PrintStream(fos);
        ) {
            // 使用 PrintStream 执行输出
            ps.println("普通字符串");
            // 直接使用 PrintStream 输出对象
            ps.println(new PrintStreamTest());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
