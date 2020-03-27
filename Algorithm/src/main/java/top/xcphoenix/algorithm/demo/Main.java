package top.xcphoenix.algorithm.demo;

/**
 * @author xuanc
 * @version 1.0
 * @date 2020/3/26 下午7:14
 */
public class Main {

    public static void main(String[] args) {

        int k = 9;
        int[] arr = new int[]{0, 1, 5, 7, 9, 3, 4};
        int[][] dp = new int[k][arr.length];

        int val = 0;
        for (int i = 1; i < arr.length; i++) {
            val += arr[i];
            System.out.println(val);
        }
        System.out.println("--------------------------");

        System.arraycopy(arr, 0, dp[0], 0, arr.length);
        for (int i = 1; i < k; i++) {
            for (int j = 1; j <= arr.length - 1; j++) {
                dp[i][j] = solve(dp, i, j);
            }
        }
        for (int j = 1; j <= arr.length - 1; j++) {
            for (int i = 1; i < k; i++) {
                System.out.println("[" + i + ", " + j +  "] ==> " + dp[i][j]);
            }
            System.out.println("================================");
        }

    }

    static int solve(int[][] dp, int k, int n) {
        if (k == 0) {
            return dp[0][n];
        }
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res += solve(dp, k - 1, i);
        }
        return res;
    }

}
