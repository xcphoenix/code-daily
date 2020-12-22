package xuanc;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * ClassName    Chapter15-StringNodeTest
 * Description
 *
 * @author xuanc
 * @version 1.0
 * @date 19-4-10 下午4:17
 */
public class StringNodeTest {

    public static void main(String[] args) {
        String src = "从明天起，做一个幸福的人\n" +
                "喂马、劈柴，周游世界\n" +
                "从明天起，关心粮食和蔬菜\n" +
                "我有一所房子，面朝大海，春暖花开\n";
        char[] buffer = new char[32];
        int hasRead = 0;
        try (
                // 以字符串作为物理节点
                StringReader sr = new StringReader(src)
        ) {
            // 采用循环读取的方式读取字符串
            while ((hasRead = sr.read(buffer)) > 0) {
                System.out.println(new String(buffer, 0, hasRead));
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        try (
                // 创建 StringWriter 时，实际上以一个 StringBuffer(因为长度可变) 作为输出节点
                // 下面指定的 20 就是 StringBuffer 的初始长度
                StringWriter sw = new StringWriter(20)
        ) {
            // 调用 StringWriter 的方法执行输出
            sw.write("从明天起，和每一个亲人通信\n" +
                    "告诉他们我的幸福\n" +
                    "那幸福的闪电告诉我的\n" +
                    "我将告诉每一个人\n");
            System.out.println(sw.toString());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
