package observer.demo;

/**
 * observer interface
 *
 * @author      xuanc
 * @date        2020/2/14 下午3:46
 * @version     1.0
 */ 
public interface Observer {

    /**
     * 当主题改变时调用此接口
     *
     * @param msg 信息
     */
    void update(String msg);

}
