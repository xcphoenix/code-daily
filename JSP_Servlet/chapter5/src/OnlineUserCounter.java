/*
 * SessionListenerDemo - OnlineUserCounter.java
 */

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class OnlineUserCounter implements HttpSessionListener {
    private static int counter = 0;         // 统计在线人数

    public static int getCounter() {
        return counter;
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("user login!");
        OnlineUserCounter.counter++;
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("user logout!");
        OnlineUserCounter.counter--;
    }
}
