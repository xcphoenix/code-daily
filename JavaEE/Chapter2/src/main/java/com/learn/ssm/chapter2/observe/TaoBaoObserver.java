package com.learn.ssm.chapter2.observe;

import java.util.Observable;
import java.util.Observer;

/**
 * ClassName    Chapter2-TaoBaoObserver
 * Description  
 *
 * @author      xuanc
 * @date        19-4-25 下午7:01
 * @version     1.0
 */ 
public class TaoBaoObserver implements Observer {

    @Override
    public void update(Observable o, Object product) {
        String newProduct = (String) product;
        System.out.println("发送新产品【" + newProduct + "】同步到淘宝商城");
    }
}
