/*
 * JSTLDemo - 简单的留言板程序
 */

package cc.openhome;

public class MessageService {
    private Message[] fakeMessages;

    public MessageService() {
        // 伪装数据库
        fakeMessages = new Message[3];
        fakeMessages[0] = new Message("caterpillar", "c's message");
        fakeMessages[1] = new Message("momor", "m's message");
        fakeMessages[2] = new Message("ham", "h's message");
    }

    public Message[] getMessages() {
        return fakeMessages;
    }
}