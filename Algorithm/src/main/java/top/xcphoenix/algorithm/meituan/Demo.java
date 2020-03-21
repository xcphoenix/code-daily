package top.xcphoenix.algorithm.meituan;

import java.util.Scanner;

/**
 * @author xuanc
 * @version 1.0
 * @date 2020/3/11 下午8:54
 */
public class Demo {

    static double maxVal = -1;
    static int[][] maxMap;
    static double[][] map;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        maxMap = new int[num][num];
        map = new double[num][num];

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                map[i][j] = scanner.nextDouble();
            }
        }

        for (int i = 0; i < num; i++) {
            int[][] record = new int[num][num];
            double[] tmpMax = new double[1];
            dfs(0, new int[num], record, tmpMax);
        }

        System.out.printf("%.2f\n", maxVal);
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if (maxMap[i][j] == 1) {
                    System.out.println((i + 1) + " " + (j + 1));
                }
            }
        }

        scanner.close();
    }

    static void dfs(int x, int[] yRecord, int[][] record, double[] tmpMax) {
        if (x >= yRecord.length) {
            if (tmpMax[0] > maxVal) {
                maxVal = tmpMax[0];
                for (int i = 0; i < record.length; i++) {
                    System.arraycopy(record[i], 0, maxMap[i], 0, record[i].length);
                }
            }
            return;
        }
        for (int j = 0; j < record.length; j++) {
            // 列走过
            if (yRecord[j] == 1) {
                continue;
            }
            record[x][j] = 1;
            yRecord[j] = 1;
            tmpMax[0] += map[x][j];
            dfs(x + 1, yRecord, record, tmpMax);
            tmpMax[0] -= map[x][j];
            record[x][j] = 0;
            yRecord[j] = 0;
        }
    }

}
