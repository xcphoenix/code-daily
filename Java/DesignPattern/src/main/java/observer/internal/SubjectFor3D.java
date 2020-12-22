package observer.internal;

import java.util.Observable;

/**
 * @author      xuanc
 * @date        2020/2/14 下午4:07
 * @version     1.0
 */ 
public class SubjectFor3D extends Observable {

    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
        setChanged();
        notifyObservers(msg);
    }

}
