package xuanc;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * ClassName    Chapter15-FileInputStreamTest
 * Description  流的学习
 *
 * @author      xuanc
 * @date        19-4-7 下午7:09
 * @version     1.0
 */ 
public class FileInputStreamTest {

    public static void main(String[] args) throws IOException {
        // 创建字节输入流
        FileInputStream fis = new FileInputStream("src/xuanc/FileInputStreamTest.java");
        // 创建一个长度为 1024 的 “竹筒”
        byte[] bbuf = new byte[1024];
        // 用于保存实际读取的字节数
        int hasRead = 0;
        // 使用循环来重复 “取水“
        while ((hasRead = fis.read(bbuf)) > 0) {
            System.out.println(new String(bbuf, 0, hasRead));
        }
        // 关闭文件输入流
        // 垃圾回收机制不能回收资源
        fis.close();
    }

}
