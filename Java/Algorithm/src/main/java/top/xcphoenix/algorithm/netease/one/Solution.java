package top.xcphoenix.algorithm.netease.one;

/**
 * @author xuanc
 * @version 1.0
 */
public class Solution {

    private static final int MOD = 9;
    private static final char CH = '.';
    private static int smallBit = 0;

    /**
     * 接收两个表示9进制数的字符串，返回表示它们相加后的9进制数的字符串
     *
     * @param num1 string字符串 第一个加数
     * @param num2 string字符串 第二个加数
     * @return string字符串
     */
    public String add(String num1, String num2) {
        int index;
        // 小数
        String zs1 = num1, zs2 = num2;
        if ((index = num1.indexOf(CH)) > 0) {
            zs1 = num1.substring(0, index);
            num1 = num1.substring(index + 1);
        } else {
            num1 = "";
        }
        if ((index = num2.indexOf(CH)) > 0) {
            zs2 = num2.substring(0, index);
            num2 = num2.substring(index + 1);
        } else {
            num2 = "";
        }
        String zs = solve(zs1, zs2, false);
        String xs = solve(num1, num2, true);
        if (xs != null) {
            if (smallBit == 0) {
                return zs + "." + xs;
            } else {
                return solve(zs, String.valueOf(smallBit), false) + "." + xs;
            }
        }

        return zs;
    }

    // num1.length > num2.length
    // @return Nullable
    public static String solve(String num1, String num2, boolean small) {
        if (num1.length() == 0) {
            return num2.length() == 0 ? null : num2;
        }
        if (num2.length() == 0) {
            return num1;
        }
        if (num2.length() > num1.length()) {
            String tmp = num1;
            num1 = num2;
            num2 = tmp;
        }

        // 进位
        int bit = 0;
        StringBuilder builder = new StringBuilder(num1);
        for (int i = num2.length() - 1; i >= 0; i--) {
            int tmp = num2.charAt(i) + num1.charAt(i) - 2 * '0' + bit;
            builder.setCharAt(i, (char) ((tmp % MOD) + '0'));
            bit = tmp / MOD;
        }
        if (bit != 0 && !small) {
            builder.insert(0, bit);
        }
        if (small) {
            smallBit = bit;
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().add("88", "11"));
    }

}