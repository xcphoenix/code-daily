package factory.method;

import factory.simple.Sender;

/**
 * @author      xuanc
 * @date        2020/2/26 上午10:39
 * @version     1.0
 */ 
public class Main {

    public static void main(String[] args) {
        SenderFactory senderFactory = new SendMailFactory();
        Sender sender = senderFactory.getObject();
        sender.send("有喷子远方来", "虽远必诛");
    }

}
