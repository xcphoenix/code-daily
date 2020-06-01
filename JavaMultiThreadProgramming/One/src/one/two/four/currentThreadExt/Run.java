package one.two.four.currentThreadExt;

/**
 * @author      xuanc
 * @date        2019/11/17 下午7:48
 * @version     1.0
 */ 
public class Run {
    public static void main(String[] args) {
        CountOperate c = new CountOperate();
        Thread t1 = new Thread(c);
        t1.setName("A");
        t1.start();
    }

}
