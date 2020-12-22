package top.xcphoenix.algorithm.leetcode;

/**
 * @author xuanc
 * @version 1.0
 * @date 2020/3/23 上午9:47
 */
public class Solution47 {

    public int maxValue(int[][] grid) {
        int x = grid.length;
        int y = grid[0].length;

        int[][] dp = new int[x][y];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < x; i++) {
            dp[i][0] += dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < y; j++) {
            dp[0][j] += dp[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < x; i++) {
            for (int j = 1; j < y; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[x - 1][y - 1];
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println(new Solution47().maxValue(grid));
    }

}
