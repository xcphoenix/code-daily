package top.xcphoenix.algorithm.netease.two;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author      xuanc
 * @version     1.0
 */ 
public class Solution {

    private static int[] skill;
    private static int[] hard;
    private static int mod;
    private static int num;
    private static int res;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        num = scanner.nextInt();
        skill = new int[num];
        hard = new int[num];
        for (int i = 0; i < num; i++) {
            skill[i] = scanner.nextInt();
        }
        for (int i = 0; i < num; i++) {
            hard[i] = scanner.nextInt();
        }
        mod = scanner.nextInt();
        scanner.close();

        Arrays.sort(skill);
        Arrays.sort(hard);

        res = 0;
        int[] map = new int[num];
        for (int i = 0; i < num; i++) {
            if (skill[0] >= hard[i]) {
                map[i] = 1;
                dfs(map, 1);
                map[i] = 0;
            }
        }

        System.out.println(res);
    }

    static void dfs(int[] map, int depth) {
        if (depth >= num) {
            res = (res + 1) % mod;
            return;
        }
        for (int i = 0; i < num; i++) {
            if (skill[depth] >= hard[i] && map[i] == 0) {
                map[i] = 1;
                dfs(map, depth + 1);
                map[i] = 0;
            }
        }
    }

}
