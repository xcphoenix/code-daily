package top.xcphoenix.algorithm.template;

/**
 * @author xuanc
 * @version 1.0
 * @date 2020/3/26 下午5:37
 */
public class LongestCommonSubsequence {

    private int dp[][];

    public LongestCommonSubsequence(String str1, String str2) {
        dp = new int[str1.length() + 1][str2.length() + 1];
        solution(str1, str2);
    }

    private void solution(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        for (int i = 0; i < m; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 2; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
    }

    public int getLCS() {
        return dp[dp.length - 1][dp[0].length - 1];
    }

    public static void main(String[] args) {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence(
                "abcde",
                "ace"
        );
        System.out.println(lcs.getLCS());
    }

}
