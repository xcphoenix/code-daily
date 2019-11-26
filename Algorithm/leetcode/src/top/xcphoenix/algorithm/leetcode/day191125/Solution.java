package top.xcphoenix.algorithm.leetcode.day191125;

import java.util.Arrays;

/**
 * longest-substring-without-repeating-characters
 *
 * @author xuanc
 * @version 1.0
 * @date 2019/11/25 下午8:07
 */
public class Solution {

    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int left = 0, i;
        int[] charIndex = new int[255];
        Arrays.fill(charIndex, -1);

        for (i = 0; i < s.length(); i++) {
            if (charIndex[s.charAt(i)] < left) {
                charIndex[s.charAt(i)] = i;
            } else {
                maxLen = Math.max(i - left, maxLen);
                left = charIndex[s.charAt(i)] + 1;
                charIndex[s.charAt(i)] = i;
            }
        }
        maxLen = Math.max(i - left, maxLen);

        return maxLen;
    }

    public static void main(String[] args) {
        String str = "abba";

        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring(str));
    }

}
