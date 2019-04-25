package com.learn.ssm.chapter2.observe;

/**
 * ClassName    Chapter2-Main
 * Description  
 *
 * @author      xuanc
 * @date        19-4-25 下午7:04
 * @version     1.0
 */ 
public class Main {

    public static void main(String[] args) {
        ProductList observable = ProductList.getInstance();
        TaoBaoObserver taoBaoObserver = new TaoBaoObserver();
        JingDongObserver jingDongObserver = new JingDongObserver();
        observable.addProductListObserver(taoBaoObserver);
        observable.addProductListObserver(jingDongObserver);
        observable.addProduct("product1");
        observable.addProduct("product2");
        observable.addProduct("product3");
    }

}
