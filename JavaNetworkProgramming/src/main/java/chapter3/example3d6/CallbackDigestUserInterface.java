package chapter3.example3d6;

import chapter3.example3d6.CallbackDigest;

import javax.xml.bind.DatatypeConverter;

/**
 * @author      xuanc
 * @date        2019/12/7 下午2:31
 * @version     1.0
 */ 
public class CallbackDigestUserInterface {

    public static void receiveDigest(byte[] digest, String name) {
        String result = name + ": " +
                DatatypeConverter.printHexBinary(digest);
        System.out.println(result);
    }

    public static void main(String[] args) {
        for (String filename : args) {
            CallbackDigest cb = new CallbackDigest(filename);
            Thread t = new Thread(cb);
            t.start();
        }
    }

}
