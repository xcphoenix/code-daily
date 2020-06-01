package factory.simple;

/**
 * 抽象产品角色
 *
 * @author      xuanc
 * @date        2020/2/26 上午9:46
 * @version     1.0
 */ 
public interface Sender {

    boolean send(String to, String msg);

}
