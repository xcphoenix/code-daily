package observer.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author      xuanc
 * @date        2020/2/14 下午3:49
 * @version     1.0
 */ 
public class ObjectFor3D implements Subject {

    private List<Observer> observers = new ArrayList<>();
    private String msg;

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(observer -> observer.update(msg));
    }

    public void setMsg(String msg) {
        this.msg = msg;
        notifyObservers();
    }

}
