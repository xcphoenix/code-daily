package top.xcphoenix.algorithm.nowcoder.bytedance2019;

import java.util.*;
import java.util.stream.Stream;

/**
 * @author      xuanc
 * @date        2020/3/5 下午9:23
 * @version     1.0
 */ 
public class Demo {

    public static void main(String[] args) {
        int num;
        long res = 0;
        Map<Character, Long> map = new HashMap<>(9);
        String[] strings;
        Scanner scanner = new Scanner(System.in);

        num = Integer.parseInt(scanner.nextLine());
        strings = new String[num];
        for (int i = 0; i < num; i++) {
            strings[i] = scanner.nextLine();
            int factory = 1;
            for (int j = strings[i].length() - 1; j >= 0; j--) {
                Long v = map.get(strings[i].charAt(j));
                map.put(strings[i].charAt(j), (v == null ? 0 : v) + factory);
                factory *= 10;
            }
        }

        System.out.println(map);

        List<Map.Entry<Character, Long>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> b.getValue().compareTo(a.getValue()));
        long baseVal = 9;
        for (Map.Entry<Character, Long> entry : list) {
            System.out.println(entry);
            map.put(entry.getKey(), baseVal);
            baseVal--;
        }

        System.out.println(map);

        for (int i = 0; i < num; i++) {
            long factory = 1;
            long tmp = 0;
            for (int j = strings[i].length() - 1; j >= 0; j--) {
                Long v = map.get(strings[i].charAt(j));
                tmp += (v * factory);
                factory *= 10;
            }
            res += tmp;
        }

        System.out.println(res);
    }

}
