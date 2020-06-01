package top.xcphoenix.algorithm.template;

/**
 * 动态规划－0-1背包问题
 * <p>
 * 给你一个可装载重量为 W 的背包和 N 个物品，
 * 每个物品有重量和价值两个属性。其中第 i 个物品的重量为 wt[i]，
 * 价值为 val[i]，现在让你用这个背包装物品，
 * 最多能装的价值是多少？
 *
 * @author xuanc
 * @version 1.0
 * @date 2020/4/4 下午5:57
 */
public class ZeroOnePackage {

    public static int solution(int packageSize, int[] weights, int[] prices) {
        int[][] dp = new int[weights.length][packageSize];

        for (int i = 1; i < weights.length; i++) {
            for (int j = 1; j < packageSize; j++) {
                dp[i][j] = Math.max(
                        // 不选择
                        dp[i - 1][packageSize],
                        // 选择物品i
                        dp[i - 1][packageSize - weights[i - 1]] + prices[i - 1]
                );
            }
        }

        return dp[weights.length - 1][packageSize - 1];
    }

    public static void main(String[] args) {
        int[] weights = new int[] {
                2, 1, 3
        };
        int[] prices = new int[] {
                4, 2, 3
        };
        int packageSize = 4;

        System.out.println(solution(packageSize, weights, prices));
    }

}
