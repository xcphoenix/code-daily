package observer.demo;

/**
 * topic interface
 *
 * @author      xuanc
 * @date        2020/2/14 下午3:45
 * @version     1.0
 */ 
public interface Subject {

    /**
     * 注册观察者
     *
     * @param observer 观察者
     */
    void registerObserver(Observer observer);

    /**
     * 移除观察者
     *
     * @param observer 观察者
     */
    void removeObserver(Observer observer);

    /**
     * 通知所有的观察者
     */
    void notifyObservers();

}
