package xuanc;

import java.io.*;

/**
 * ClassName    Chapter15-InsertContent
 * Description  
 *
 * @author      xuanc
 * @date        19-5-5 下午9:32
 * @version     1.0
 */ 
public class InsertContent {

    public static void insert(String fileName, long pos, String insertContent) throws IOException {
        // 创建临时文件
        File tmp = File.createTempFile("tmp", null);
        tmp.deleteOnExit();

        try (
                RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
                // 使用临时文件来保存插入点之后的数据
                FileOutputStream tmpOut = new FileOutputStream(tmp);
                FileInputStream tmpIn = new FileInputStream(tmp);
        ){
            raf.seek(pos);

            // 将插入点后的内容读取到临时文件中保存
            byte[] bbuf = new byte[64];
            // 用于保存实际读取的字节数
            int hasRead = 0;
            // 循环处理
            while ((hasRead = raf.read(bbuf)) > 0) {
                // 将读取的数据写入临时文件
                tmpOut.write(bbuf, 0, hasRead);
            }

            // 插入内容
            raf.seek(pos);
            // 追加输入的内容
            raf.write(insertContent.getBytes());
            // 追加临时文件的内容
            while ((hasRead = tmpIn.read(bbuf)) > 0) {
                raf.write(bbuf, 0, hasRead);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        insert("src/xuanc/InsertContent.java", 45, "\n// 插入的内容～～");
    }

}
