package top.xcphoenix.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xuanc
 * @version 1.0
 * @date 2020/3/21 下午6:13
 */
public class Solution784 {

    public List<String> letterCasePermutation(String S) {
        List<String> lists = new ArrayList<>();
        dfs(S.toCharArray(), 0, lists);
        return lists;
    }

    void dfs(char[] str, int count, List<String> lists) {
        if (count >= str.length) {
            lists.add(String.valueOf(str));
            return;
        }
        char old = str[count];
        if (Character.isLetter(old)) {
            dfs(str, count + 1, lists);
            str[count] = convert(old);
            dfs(str, count + 1, lists);
            str[count] = old;
        } else {
            dfs(str, count + 1, lists);
        }
    }

    char convert(char ch) {
        if (Character.isUpperCase(ch)) {
            return Character.toLowerCase(ch);
        } else {
            return Character.toUpperCase(ch);
        }
    }

    public static void main(String[] args) {
        String str = "a1b2";
        System.out.println(new Solution784().letterCasePermutation(str));
    }

}
