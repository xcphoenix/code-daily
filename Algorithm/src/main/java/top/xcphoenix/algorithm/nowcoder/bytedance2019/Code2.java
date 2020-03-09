package top.xcphoenix.algorithm.nowcoder.bytedance2019;

import java.util.Scanner;

/**
 * @author      xuanc
 * @date        2020/3/5 下午6:37
 * @version     1.0
 */ 
public class Code2 {

    public static void main(String[] args) {
        int num;
        int distance;
        int[] buildings;
        int peopleNum = 3;

        Scanner scanner = new Scanner(System.in);
        num = scanner.nextInt();
        distance = scanner.nextInt();
        buildings = new int[num];
        for (int i = 0; i < num; i++) {
            buildings[i] = scanner.nextInt();
        }

        System.out.println(solve(0, buildings, distance, peopleNum, buildings[buildings.length - 1]));
        scanner.close();
    }

    static int solve(int startIndex, int[] buildings, int distance, int peopleNum, int maxLoc) {
        if (peopleNum == 0) {
            return 1;
        }
        if (startIndex >= buildings.length || buildings[startIndex] > maxLoc) {
            return 0;
        }
        int k = solve(startIndex + 1, buildings, distance, peopleNum, buildings[buildings.length - 1])
                + solve(startIndex + 1, buildings, distance, peopleNum - 1, Math.min(buildings[startIndex] + distance + 1, maxLoc));
        System.out.println("startIndex: " + startIndex + ", peopleNum: " + peopleNum + ", maxLoc: " + maxLoc + ", res = " + k);
        return k;
    }



}
