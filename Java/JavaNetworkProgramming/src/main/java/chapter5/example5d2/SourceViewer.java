package chapter5.example5d2;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author      xuanc
 * @date        2019/12/7 下午10:28
 * @version     1.0
 */ 
public class SourceViewer {

    public static void main(String[] args) {
        if (args.length > 0) {
            InputStream in = null;
            try {
                URL u = new URL(args[0]);
                in = u.openStream();
                // cache
                in = new BufferedInputStream(in);
                Reader r = new InputStreamReader(in);
                int c;
                while ((c = r.read()) != -1 ) {
                    System.out.print((char) c);
                }
            } catch (MalformedURLException ex) {
                System.err.println(args[0] + " is not a parseable URL");
            } catch (IOException ex) {
                System.err.println(ex);
            } finally {
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        // some
                    }
                }
            }
        }
    }

}
