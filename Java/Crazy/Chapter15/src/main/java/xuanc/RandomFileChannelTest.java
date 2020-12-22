package xuanc;

import org.apache.tools.ant.taskdefs.Length;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.FileChannel;

/**
 * ClassName    Chapter15-RandomFileChannelTest
 * Description  
 *
 * @author      xuanc
 * @date        19-5-7 下午10:56
 * @version     1.0
 */
public class RandomFileChannelTest {

    public static void main(String[] args) throws IOException {
        File f = new File("target/a.txt");
        try (
                // 创建一个 RandomAccessFile 对象
                RandomAccessFile raf = new RandomAccessFile(f, "rw");
                // 获取对应的 Channel
                FileChannel randomChannel = raf.getChannel()
        ) {
            // 将数据都映射成为 ByteBuffer
            ByteBuffer buffer = randomChannel.map(FileChannel.MapMode.READ_ONLY, 0, f.length());
            // 把 Channel 的记录指针移动到最后
            randomChannel.position(f.length());
            // 将 buffer 中的所有数据输出
            randomChannel.write(buffer);
        }
    }

}
