package top.xcphoenix.algorithm.leetcode;


import java.util.Arrays;

/**
 * @author xuanc
 * @version 1.0
 * @date 2020/3/21 下午11:04
 */
public class Solution0807 {

    int count = 0;
    int[] record = new int[256];

    public String[] permutation(String S) {
        String[] strings = new String[calNum(S.length())];
        dfs(new StringBuilder(), S, strings);
        return strings;
    }

    void dfs(StringBuilder builder, String str, String[] strings) {
        if (builder.length() >= str.length()) {
            strings[count] = builder.toString();
            count++;
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (record[ch - '0'] != 1) {
                record[ch - '0'] = 1;
                dfs(builder.append(ch), str, strings);
                record[ch - '0'] = 0;
                builder.deleteCharAt(builder.length() - 1);
            }
        }
    }

    static int calNum(int n) {
        int res = 1;
        for (int i = n; i > 0; i--) {
            res *= i;
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "qwe";
        System.out.println(Arrays.toString(new Solution0807().permutation(str)));
    }

}
