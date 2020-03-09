package demo.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author      xuanc
 * @date        2020/2/21 下午3:24
 * @version     1.0
 */ 
public class Demo {

}

class Info {
    private String name;
    private String content;
    private boolean flag = true;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

}