package chapter7.example7d1;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author      xuanc
 * @date        2019/12/9 下午3:06
 * @version     1.0
 */ 
public class SourceViewer2 {

    public static void main(String[] args) {
        if (args.length > 0) {
            try {
                URL u = new URL(args[0]);
                URLConnection uc = u.openConnection();
                try (InputStream raw = uc.getInputStream()) {
                    InputStream buffer = new BufferedInputStream(raw);
                    // 将 InputStream 串联到一个 Reader
                    Reader reader = new InputStreamReader(buffer);
                    int c;
                    while ((c = reader.read()) != -1) {
                        System.out.print((char) c);
                    }
                }
            } catch (MalformedURLException ex) {
                System.err.println(args[0] + " is not a parseable URL");
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }
    }
}
