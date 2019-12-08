package chapter5.example5d3;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author      xuanc
 * @date        2019/12/8 下午3:35
 * @version     1.0
 */ 
public class ContentGetter {

    public static void main(String[] args) {

        if (args.length > 0) {
            try {
                URL u = new URL(args[0]);
                Object o = u.getContent();
                System.out.println("I got a " + o.getClass().getName());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
