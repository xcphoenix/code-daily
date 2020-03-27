package top.xcphoenix.algorithm.leetcode;

/**
 * @author      xuanc
 * @date        2020/3/23 上午10:27
 * @version     1.0
 */
public class Solution14v1 {

    /**
     * dp[i][j] 长为i的绳子分为m段的最大乘积
     */
    public int cuttingRope(int n, int p) {
        int maxMulti = 0;
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i][i] = 1;
            dp[i][1] = i;
        }
        // 长为j，分为i段
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                for (int k = j - 1; k >= i; k--) {
                    dp[j][i] = Math.max(dp[j][i], (j - k) * dp[k][i - 1]);
                }
            }
        }
        for (int i = 2; i <= n; i++) {
            maxMulti = Math.max(maxMulti, dp[n][i]);
        }
        return maxMulti;
    }

    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(
                        Math.max((i - j) * dp[j], j * dp[i - j]),
                        Math.max(j * (i - j), dp[i])
                );
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution14v1().cuttingRope(10));
    }

}
