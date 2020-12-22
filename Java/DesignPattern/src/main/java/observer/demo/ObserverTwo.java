package observer.demo;

/**
 * @author      xuanc
 * @date        2020/2/14 下午3:56
 * @version     1.0
 */ 
public class ObserverTwo implements Observer {

    /**
     * 关注的主题
     */
    private Subject subject;

    public ObserverTwo(Subject subject) {
        this.subject = subject;
        subject.registerObserver(this);
    }

    @Override
    public void update(String msg) {
        System.out.println(this.getClass() + " get number: " + msg + " from " + subject.getClass());
    }

}
