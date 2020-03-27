package top.xcphoenix.algorithm.leetcode;

import java.util.Stack;

/**
 * @author xuanc
 * @version 1.0
 * @date 2020/3/22 下午12:21
 */
public class Solution526 {

    private int res = 0;
    private int[] flags = new int[15];
    private Stack<Integer> stack = new Stack<>();

    public int countArrangement(int N) {
        backtrace(1, N);
        return res;
    }

    void backtrace(int i, int n) {
        if (i == n + 1) {
            res++;
            return;
        }
        for (int j = 1; j <= n; j++) {
            if (flags[j] == 0 && isValid(j, i)) {
                flags[j] = 1;
                stack.push(j);
                backtrace(i + 1, n);
                flags[j] = 0;
                stack.pop();
            }
        }
    }

    boolean isValid(int val, int i) {
        return val % i == 0 || i % val == 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution526().countArrangement(3));
    }

}
