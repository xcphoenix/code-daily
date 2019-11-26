package t12;

/**
 * @author      xuanc
 * @date        2019/11/20 上午11:37
 * @version     1.0
 */ 
public class Run2 {
    public static void main(String[] args) {
        Thread.currentThread().interrupt();
        System.out.println("是否停止1? = " + Thread.interrupted());
        System.out.println("是否停止2? = " + Thread.interrupted());
        System.out.println("end");
    }
}
