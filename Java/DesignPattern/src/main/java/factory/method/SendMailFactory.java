package factory.method;

import factory.simple.MailSender;
import factory.simple.Sender;

/**
 * @author      xuanc
 * @date        2020/2/26 上午10:38
 * @version     1.0
 */ 
public class SendMailFactory implements SenderFactory {

    @Override
    public Sender getObject() {
        return new MailSender();
    }

}
