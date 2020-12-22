package com.learn.ssm.chapter2.observe;

import java.util.Observable;
import java.util.Observer;

/**
 * ClassName    Chapter2-JingDongObserver
 * Description  京东和淘宝电商接口
 *              ----------------------
 *              作为观察者需要实现 java.util.Observer 的实现 update() 方法
 *
 * @author      xuanc
 * @date        19-4-25 下午5:12
 * @version     1.0
 */ 
public class JingDongObserver implements Observer {

    @Override
    public void update(Observable o, Object product) {
        String newProduct = (String) product;
        System.out.println("发送新产品【" + newProduct + "】同步到京东商城");
    }
}


