package top.xcphoenix.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xuanc
 * @version 1.0
 * @date 2020/3/21 下午6:32
 */
public class Solution401 {

    private int hourNum = 4;
    private int minNum = 6;
    private final static int[] BITS = {
            1,
            1 << 1,
            1 << 2,
            1 << 3,
            1 << 4,
            1 << 5
    };

    public List<String> readBinaryWatch(int num) {
        List<String> lists = new ArrayList<>();
        for (int i = 0; i <= num; i++) {
            int j = num - i;
            if (i > hourNum || j > minNum) {
                continue;
            }
            List<Integer> hour = new ArrayList<>();
            List<Integer> minute = new ArrayList<>();
            dfs(new int[]{0}, 0, i, 0, hourNum, hour);
            dfs(new int[]{0}, 0, j, 0, minNum, minute);
            for (Integer k : hour) {
                for (Integer n : minute) {
                    if (k > 11 || n > 59) {
                        continue;
                    }
                    lists.add(String.format("%d:%02d", k, n));
                }
            }
        }
        Collections.sort(lists);
        return lists;
    }

    /**
     * @param val 值
     * @param oneNum 1的个数
     * @param count 迭代次数
     * @param countMax 最大值
     * @param lists 存放对应数据
     */
    void dfs(int[] val, int oneNum, int oneMax,
             int count, int countMax, List<Integer> lists) {
        if (countMax - count == oneMax - oneNum) {
            int k = val[0];
            for (int i = count; i < countMax; i++) {
                k = setBit(k, i);
            }
            lists.add(k);
            return;
        }
        if (count >= countMax || oneNum >= oneMax) {
            lists.add(val[0]);
            return;
        }
        dfs(val, oneNum, oneMax, count + 1, countMax, lists);
        val[0] = setBit(val[0], count);
        dfs(val, oneNum + 1, oneMax, count + 1, countMax, lists);
        val[0] = clrBit(val[0], count);
    }

    static int setBit(int val, int index) {
        return val | BITS[index];
    }

    static int clrBit(int val, int index) {
        return val ^ BITS[index];
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(new Solution401().readBinaryWatch(n));
    }


}
