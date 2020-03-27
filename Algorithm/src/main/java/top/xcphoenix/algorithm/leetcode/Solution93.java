package top.xcphoenix.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xuanc
 * @version 1.0
 * @date 2020/3/22 下午4:25
 */
public class Solution93 {

    private static final int IP_NUMS = 4;

    public List<String> restoreIpAddresses(String s) {
        List<String> strings = new ArrayList<>();
        backtrace(0, 0, s, new ArrayList<>(), strings);
        return strings;
    }

    void backtrace(int last, int cnt, String str, List<String> ips, List<String> strings) {
        if (cnt >= str.length() || ips.size() == IP_NUMS) {
            if (ips.size() == IP_NUMS && cnt >= str.length()) {
                strings.add(String.join(".", ips));
            }
            return;
        }
        backtrace(last, cnt + 1, str, ips, strings);
        String subStr = str.substring(last, cnt + 1);
        if ((subStr = isValidSubIp(subStr)) != null) {
            ips.add(subStr);
            backtrace(cnt + 1, cnt + 1, str, ips, strings);
            ips.remove(ips.size() - 1);
        }
    }

    String isValidSubIp(String str) {
        if (str.length() != 0 && str.length() < 4) {
            if (str.length() > 1 && str.charAt(0) == '0') {
                return null;
            }
            int k = Integer.parseInt(str);
            return k > 255 ? null : String.valueOf(k);
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(new Solution93().restoreIpAddresses("010010"));
    }

}
