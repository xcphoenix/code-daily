package top.xcphoenix.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author      xuanc
 * @date        2020/3/21 下午11:30
 * @version     1.0
 */ 
public class Solution0809 {

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        dfs(0, 0, n, new StringBuilder(), list);
        return list;
    }

    void dfs(int left, int right, int all, StringBuilder str, List<String> list) {
        if (left == right && left == all) {
            list.add(str.toString());
        }
        if (left < all) {
            dfs(left + 1, right, all, str.append('('), list);
            str.deleteCharAt(str.length() - 1);
        }
        if (right < all && right < left) {
            dfs(left, right + 1, all, str.append(')'), list);
            str.deleteCharAt(str.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution0809().generateParenthesis(4));
    }
}
