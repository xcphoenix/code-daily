package xuanc;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

/**
 * ClassName    Chapter15-ReadFile
 * Description  
 *
 * @author      xuanc
 * @date        19-5-7 下午11:06
 * @version     1.0
 */ 
public class ReadFile {

    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/main/java/xuanc/ReadFile.java");
                FileChannel fcin = fis.getChannel()
        ) {
            ByteBuffer bbuff = ByteBuffer.allocate(256);
            while (fcin.read(bbuff) != -1) {
                bbuff.flip();
                Charset charset = Charset.forName("UTF-8");
                CharsetDecoder decoder = charset.newDecoder();
                CharBuffer cbuff = decoder.decode(bbuff);
                System.out.print(cbuff);
                bbuff.clear();
            }
        }
    }

}
