package xuanc;

import java.io.FileReader;
import java.io.IOException;

/**
 * ClassName    Chapter15-FileReaderTest
 * Description  
 *
 * @author      xuanc
 * @date        19-4-7 下午7:40
 * @version     1.0
 */ 
public class FileReaderTest {

    public static void main(String[] args) throws IOException {
        try (
            // 创建字符输入流
            FileReader fr = new FileReader("src/xuanc/FileReaderTest.java")) {
            char[] cbuf = new char[32];
            int hasRead = 0;
            while ((hasRead = fr.read(cbuf)) > 0) {
                // 取出“竹筒”中的水滴字符，将字符数组转换为字符串输入
                System.out.println(new String(cbuf, 0, hasRead));
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
