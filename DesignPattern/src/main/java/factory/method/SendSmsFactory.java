package factory.method;

import factory.simple.Sender;
import factory.simple.SmsSender;

/**
 * @author      xuanc
 * @date        2020/2/26 上午10:38
 * @version     1.0
 */ 
public class SendSmsFactory implements SenderFactory {

    @Override
    public Sender getObject() {
        return new SmsSender();
    }

}
