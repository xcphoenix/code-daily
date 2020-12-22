package com.learn.ssm.chapter2.observe;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * ClassName    Chapter2-ProductList
 * Description  被观察的产品列表
 *              ----------------------
 *              观察者模式中需要继承 java.util.Observable　类
 *
 * @author      xuanc
 * @date        19-4-25 下午4:46
 * @version     1.0
 */ 
public class ProductList extends Observable {

    /**
     * 产品列表
     */
    private List<String> productList = null;

    /**
     * 类唯一实例
     */
    private static ProductList instance;

    /**
     * 私有化类构造器，保证唯一性
     */
    private ProductList() {}

    /**
     * 取得唯一实例
     * @return　产品列表唯一实例
     */
    public static ProductList getInstance() {
        if (instance == null) {
            instance = new ProductList();
            instance.productList = new ArrayList<String>();
        }
        return instance;
    }

    /**
     * 增加观察者（电商接口）
     * @param observer　观察者
     */
    public void addProductListObserver(Observer observer) {
        this.addObserver(observer);
    }

    public void addProduct(String newProduct) {
        productList.add(newProduct);
        System.out.println("产品列表新增了产品：" + newProduct);
        // 设置被观察的对象发生变化
        this.setChanged();
        // 通知观察者，传递新产品
        this.notifyObservers(newProduct);
    }

}
