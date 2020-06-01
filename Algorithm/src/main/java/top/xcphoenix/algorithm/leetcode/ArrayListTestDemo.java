package top.xcphoenix.algorithm.leetcode;

/**
 * @author      xuanc
 * @date        2020/3/22 下午11:26
 * @version     1.0
 */ 
public class ArrayListTestDemo {

    public static void main(String[] args) {
        long base = 10;
        while (base < Integer.MAX_VALUE) {
            System.out.println(base >> 1);
            base = base + (base >> 1);
        }
    }

}
