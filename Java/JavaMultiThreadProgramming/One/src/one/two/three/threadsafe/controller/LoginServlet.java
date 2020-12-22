package one.two.three.threadsafe.controller;

/**
 * @author      xuanc
 * @date        2019/11/17 下午6:52
 * @version     1.0
 */ 
public class LoginServlet {
    private static String usernameRef;
    private static String passwordRef;

    synchronized public static void doPost(String username, String password) {
        try {
            usernameRef = username;
            if (username.equals("a")) {
                Thread.sleep(5000);
            }
            passwordRef = password;
            System.out.println("username=" + usernameRef + " password=" + password);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
