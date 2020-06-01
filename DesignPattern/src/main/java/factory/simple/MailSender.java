package factory.simple;

/**
 * @author      xuanc
 * @date        2020/2/26 上午9:49
 * @version     1.0
 */ 
public class MailSender implements Sender {

    @Override
    public boolean send(String to, String msg) {
        System.out.println("MailSender->> 收件人：" + to + "，消息为：" + msg);
        return true;
    }

}
