package book.chapter2;

import book.annotation.NotThreadSafe;

/**
 * @author      xuanc
 * @date        2020/2/1 下午5:28
 * @version     1.0
 */
@NotThreadSafe
public class LazyInitRace {

    private ExpensiveObject instance = null;

    public ExpensiveObject getInstance() {
        if (instance == null) {
            instance = new ExpensiveObject();
        }
        return instance;
    }

}

class ExpensiveObject {
    /* example */
}