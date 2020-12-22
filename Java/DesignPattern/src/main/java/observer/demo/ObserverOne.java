package observer.demo;

/**
 * @author      xuanc
 * @date        2020/2/14 下午3:53
 * @version     1.0
 */ 
public class ObserverOne implements Observer {

    /**
     * 关注的主题
     */
    private Subject subject;

    public ObserverOne(Subject subject) {
        this.subject = subject;
        subject.registerObserver(this);
    }

    @Override
    public void update(String msg) {
        System.out.println(this.getClass() + " get number: " + msg + " from " + subject.getClass());
    }

}
