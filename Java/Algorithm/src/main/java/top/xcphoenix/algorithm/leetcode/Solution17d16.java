package top.xcphoenix.algorithm.leetcode;

/**
 * @author xuanc
 * @version 1.0
 * @date 2020/3/23 下午5:30
 */
public class Solution17d16 {

    /**
     * 假设 <strong>dp[i]</strong> 为 0～i 的最优解
     * 对于dp[i]而言，要么选择要么不选择，如果不选择，那么dp[i]=dp[i-1]
     * 要么选择，由于不能连续，dp[i-1]可能会存在选择nums[i-1]的情况，如果不选择nums[i-1]，dp[i-1]=dp[i-2]，
     * 所以dp[i]=dp[i-2]+nums[i]
     *
     * <li><code>dp[i]=max(dp[i-1], dp[i - 2] + k[i])</code><li/>
     */
    public int massage(int[] nums) {
        if (nums.length < 2) {
            return nums.length == 1 ? nums[0] : 0;
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{
                // 2, 1, 4, 5, 3, 1, 1, 3
        };
        System.out.println(new Solution17d16().massage(nums));
    }

}
