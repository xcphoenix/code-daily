package top.xcphoenix.algorithm.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author      xuanc
 * @date        2020/3/22 下午6:37
 * @version     1.0
 */ 
public class Solution945 {

    private int cnt = 0;
    private Set<Integer> set = new HashSet<>();

    public int minIncrementForUnique(int[] A) {
        Arrays.sort(A);
        for (int i = 0; i < A.length; i++) {
            if (set.contains(A[i])) {
                int k = A[i - 1] - A[i] + 1;
                A[i] += k;
                cnt += k;
            }
            set.add(A[i]);
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(new Solution945().minIncrementForUnique(new int[] {3, 2, 1, 2, 1, 7}));
    }

}
