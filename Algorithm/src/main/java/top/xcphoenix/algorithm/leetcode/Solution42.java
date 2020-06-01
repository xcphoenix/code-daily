package top.xcphoenix.algorithm.leetcode;

/**
 * @author      xuanc
 * @date        2020/3/23 上午9:57
 * @version     1.0
 */ 
public class Solution42 {

    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i - 1] >= 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
            maxSum = Math.max(maxSum, dp[i]);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution42().maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
    }

}
