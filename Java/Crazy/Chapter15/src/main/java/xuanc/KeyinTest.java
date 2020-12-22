package xuanc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * ClassName    Chapter15-KeyinTest
 * Description
 *
 * @author xuanc
 * @version 1.0
 * @date 19-4-10 下午4:34
 */
public class KeyinTest {

    public static void main(String[] args) {
        try (
                // 将 System.in 对象转换成 Reader 对象
                InputStreamReader reader = new InputStreamReader(System.in);
                // 将普通的 Reader 对象包装成 BufferedReader
                BufferedReader br = new BufferedReader(reader)
        ) {
            String line = null;
            // 采用循环的方式来逐行的读取
            while ((line = br.readLine()) != null) {
                // 如果读取的字符串为 "exit" 退出
                if ("exit".equals(line)) {
                    System.exit(1);
                }
                // 打印读取的内容
                System.out.println("输入内容为：" + line);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

}
