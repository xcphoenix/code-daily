package xuanc;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * ClassName    Chapter15-AppendContent
 * Description  
 *
 * @author      xuanc
 * @date        19-5-5 下午9:27
 * @version     1.0
 */ 
public class AppendContent {

    public static void main(String[] args) {
        try (
                // 以读、写方式打开一个 RandomAccessFile 对象
                RandomAccessFile raf = new RandomAccessFile("out.txt", "rw")
        ) {
           raf.seek(raf.length());
           raf.write("追加的内容！\n".getBytes());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
