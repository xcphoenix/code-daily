package top.xcphoenix.algorithm.leetcode;

import java.util.*;

/**
 * TODO 剪枝优化
 * @author xuanc
 * @version 1.0
 * @date 2020/3/22 下午5:30
 */
public class Solution1307 {

    private int[] record = new int[10];
    private Set<Character> chSet = new HashSet<>();

    public boolean isSolvable(String[] words, String result) {
        Arrays.stream(words).forEach(this::putSet);
        putSet(result);
        return backtrack(0, chSet.toArray(new Character[0]), new HashMap<>(), words, result);
    }

    void putSet(String s) {
        for (int i = 0; i < s.length(); i++) {
            chSet.add(s.charAt(i));
        }
    }

    boolean backtrack(int count, Character[] chars, Map<Character, Integer> map, String[] words, String result) {
        if (count >= chars.length) {
            int leftVal = 0;
            for (String word : words) {
                leftVal += convert(word, map);
            }
            return leftVal == convert(result, map);
        }
        char ch = chars[count];
        for (int i = 0, recordLength = record.length; i < recordLength; i++) {
            if (record[i] != 1) {
                record[i] = 1;
                map.put(ch, i);
                if (backtrack(count + 1, chars, map, words, result)) {
                    System.out.println(map.toString());
                    return true;
                }
                map.remove(ch);
                record[i] = 0;
            }
        }
        return false;
    }

    int convert(String items, Map<Character, Integer> map) {
        int res = 0;
        int base = 1;
        for (int i = items.length() - 1; i >= 0; i--) {
            res += base * map.get(items.charAt(i));
            base *= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        String[] words = new String[]{
                "SEIS", "CATORCE", "SETENTA"
        };
        String result = "NOVENTA";
        System.out.println(new Solution1307().isSolvable(words, result));
    }

}
