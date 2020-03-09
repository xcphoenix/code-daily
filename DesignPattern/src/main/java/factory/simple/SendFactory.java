package factory.simple;

/**
 * @author      xuanc
 * @date        2020/2/26 上午9:55
 * @version     1.0
 */ 
public class SendFactory {

    public Sender getObject(String type) {
        Sender sender = null;
        switch (type) {
            case "mail": {
                sender = new MailSender();
                break;
            }
            case "sms": {
                sender = new SmsSender();
                break;
            }
            default: {
               throw new IllegalArgumentException("type " + type + " is not found");
            }
        }
        return sender;
    }

}
