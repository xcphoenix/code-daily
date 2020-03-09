package factory.method;

import factory.simple.Sender;

/**
 * 抽象工厂
 *
 * @author xuanc
 * @version 1.0
 * @date 2020/2/26 上午10:37
 */
public interface SenderFactory {

    Sender getObject();

}
