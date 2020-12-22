package top.xcphoenix.algorithm.template;

import java.util.Arrays;

/**
 * <h1>最长递增子序列</h1>
 * <li> 时间复杂度：<code>O(N^2)</code></li>

 * 二分查找：时间复杂度 <code>O(NlogN)</code>
 *
 * @author      xuanc
 * @date        2020/4/4 下午5:22
 * @version     1.0
 */ 
public class LongIncreasingSubsequence {

    public static int solution(int[] arr) {
        // dp[i] ==> 以 arr[i] 为结尾的最长递增子序列
        int[] dp = new int[arr.length];
        // base case
        dp[0] = 1;

        for (int i = 1; i < arr.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
        }

        int res = 0;
        for (int val : dp) {
            res = Math.max(res, val);
        }
        System.out.println(Arrays.toString(dp));
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {
            1, 4, 3, 4, 2, 3
        };
        System.out.println(solution(nums));
    }

}
