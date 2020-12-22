package chapter7.example7d2;

import java.awt.desktop.SystemEventListener;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author      xuanc
 * @date        2019/12/9 下午3:48
 * @version     1.0
 */ 
public class EncodingAwareSourceViewer {

    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            try {
                // 设置默认编码方式
                String encoding = "ISO-8859-1";
                URL u = new URL(args[i]);
                URLConnection uc = u.openConnection();
                String contentType = uc.getContentType();
                int encodingStart = contentType.indexOf("charset=");
                if (encodingStart != -1) {
                    encoding = contentType.substring(encodingStart + 8);
                }
                InputStream in = new BufferedInputStream(uc.getInputStream());
                Reader r = new InputStreamReader(in, encoding);
                int c;
                while ((c = r.read()) != -1) {
                    System.out.println((char) c);
                }
                r.close();
            } catch (MalformedURLException ex) {
                System.err.println(args[0] + " is not a parseable URL");
            } catch (UnsupportedEncodingException ex) {
                System.err.println("Server sent an encoding Java does not support: " + ex.getMessage());
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }
    }

}
