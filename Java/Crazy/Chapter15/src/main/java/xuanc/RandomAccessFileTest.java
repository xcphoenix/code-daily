package xuanc;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * ClassName    Chapter15-RandomAccessFileTest
 * Description  
 *
 * @author      xuanc
 * @date        19-5-5 下午9:19
 * @version     1.0
 */ 
public class RandomAccessFileTest {

    public static void main(String[] args) {
        try (
                RandomAccessFile raf = new RandomAccessFile(
                        "src/xuanc/RandomAccessFileTest.java", "r")
        ) {
            // 获取 RandomAccessFile 对象文件指针的位子，初始位置为０
            System.out.println("RandomAccessFile 的文件指针的初始位置: "
                + raf.getFilePointer());
            // 移动 raf 文件记录指针的位置
            raf.seek(300);
            byte[] bbuf = new byte[1024];
            // 用于保存实际读取的字节数
            int hasRead = 0;
            // 使用循环来重复“取水”过程
            while ((hasRead = raf.read(bbuf)) > 0) {
                // 取出“竹筒”中的字节，将字节数组转换为字符输入
                System.out.println(new String(bbuf, 0, hasRead));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
