package xuanc;

import java.io.*;

/**
 * ClassName    Chapter15-FileOutputStreamTest
 * Description
 *
 * @author xuanc
 * @version 1.0
 * @date 19-4-10 下午3:35
 */
public class FileOutputStreamTest {

    public static void main(String[] args) {
        // File tmpOutputStream = new File("src/xuanc/newFile.txt");
        // try {
        //     tmpOutputStream.createNewFile();
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }
        try (
                // 创建字节输入流
                FileInputStream fis = new FileInputStream("src/xuanc/FileOutputStreamTest.java");
                /*
                 * 创建字节输出流
                 * -----------
                 * 如果文件存在但是是目录，或者不存在但却无法创建，或者不能被打开则会抛出异常
                 */
                FileOutputStream fos = new FileOutputStream("src/xuanc/newFile.txt")
        ) {
            byte[] bbuf = new byte[32];
            int hasRead = 0;
            // 循环从输入流中取出数据
            while ((hasRead = fis.read(bbuf)) > 0) {
                // 没读取一次，即写入文件输入流，读了多少，就写了多少
                fos.write(bbuf, 0, hasRead);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

}
