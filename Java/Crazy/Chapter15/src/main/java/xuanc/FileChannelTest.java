package xuanc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * ClassName    Chapter15-FileChannelTest
 * Description  
 *
 * @author      xuanc
 * @date        19-5-7 下午4:27
 * @version     1.0
 */ 
public class FileChannelTest {

    public static void main(String[] args) {
        File f = new File("src/main/java/xuanc/FileChannelTest.java");
        try (
                // 以文件输入流创建 FileChannel
                FileChannel inChannel = new FileInputStream(f).getChannel();
                // 以文件输出流创建 FileChannel
                FileChannel outChannel = new FileOutputStream("target/a.txt").getChannel()
        ) {
            // 将 FileChannel 里的全部数据映射成 ByteBuffer
            MappedByteBuffer buffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, f.length());
            // 使用 GBK 的字符集来创建解码器
            Charset charset = Charset.forName("UTF-8");
            // 直接将 Buffer 中的数据全部输出
            outChannel.write(buffer);
            // 复原 limit, position 的位置
            buffer.clear();
            // 创建解码器 (CharsetDecoder) 对象
            CharsetDecoder decoder = charset.newDecoder();
            // 使用解码器将 ByteBuffer 转换为 CharBuffer
            CharBuffer charBuffer = decoder.decode(buffer);
            // CharBuffer 的 toString 方法可以获取对应的字符串
            System.out.println(charBuffer);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
