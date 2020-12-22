package xuanc;

import java.io.FileReader;
import java.io.IOException;
import java.io.PushbackReader;

/**
 * ClassName    Chapter15-PushbackTest
 * Description
 *
 * @author xuanc
 * @version 1.0
 * @date 19-4-10 下午4:44
 */
public class PushbackTest {

    public static void main(String[] args) {
        try (
                // 创建一个 PushbackReader 对象，指定退回换成去的长度为 64
                PushbackReader pr = new PushbackReader(new FileReader("src/xuanc/PushbackTest.java"), 64)
        ) {
            char[] buf = new char[32];
            // 用来保存上次读取的字符串内容
            String lastContent = "";
            int hasRead = 0;
            // 循环读取文档内容
            while ((hasRead = pr.read(buf)) > 0) {
                // 将读取的内容转换为字符串
                String content = new String(buf, 0, hasRead);
                int targetIndex = 0;
                // 将上次读取的字符串和本次读取的字符串拼接起来
                // 查看是否包含目标字符串，如果包含目标字符串
                if ((targetIndex = (lastContent + content).indexOf("new PushbackReader")) > 0) {
                    // 将本次内容和上一次内容一起推回缓冲区
                    pr.unread((lastContent + content).toCharArray());
                    // 重新定义一个长度为 targetIndex 的 char 数组
                    if (targetIndex > 32) {
                        buf = new char[targetIndex];
                    }
                    pr.read(buf, 0, targetIndex);
                    // 打印读取的内容
                    System.out.print(new String(buf, 0, targetIndex));
                    System.exit(0);
                }
                else {
                    System.out.print(lastContent);
                    lastContent = content;
                }
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

}
