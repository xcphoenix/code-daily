package observer.internal;

import java.util.Observable;
import java.util.Observer;

/**
 * @author      xuanc
 * @date        2020/2/14 下午4:10
 * @version     1.0
 */ 
public class ObserverOne implements Observer {

    /**
     * 更新
     *
     * @param o subject
     * @param arg 参数
     */
    @Override
    public void update(Observable o, Object arg) {
        System.out.println(o.getClass() + " notify: " + arg);
    }

}
