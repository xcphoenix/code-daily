package factory.simple;

/**
 * @author      xuanc
 * @date        2020/2/26 上午10:01
 * @version     1.0
 */ 
public class Main {

    public static void main(String[] args) {
        SendFactory factory = new SendFactory();
        Sender sender = factory.getObject("mail");
        sender.send("来自远方", "Hello World");
    }

}
