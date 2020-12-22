package top.xcphoenix.algorithm.lcof;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author xuanc
 * @version 1.0
 * @date 2020/3/1 下午4:19
 */
public class Code13 {

    @Test
    public void test() {
        System.out.println(main(3, 1, 0));
    }

    private static boolean[][] map;
    private static int[][] direct = new int[][]{
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
    };

    private static int main(int mVal, int nVal, int k) {
        map = new boolean[mVal][nVal];
        dfs(0, 0, mVal, nVal, k);
        int sum = 0;
        for(boolean[] bmap : map) {
            for (boolean val : bmap) {
                if (val) {
                    sum++;
                }
            }
        }
        return sum;
    }

    private static void dfs(int m, int n, int mVal, int nVal, int k) {
        map[m][n] = true;
        IntStream.range(0, direct.length).forEach(i -> {
            int newM = m + direct[i][0];
            int newN = n + direct[i][1];
            if (boundCheck(newM, newN, mVal, nVal) && isIn(newM, newN, k)) {
                dfs(newM, newN, mVal, nVal, k);
            }
        });
    }

    private static boolean boundCheck(int m, int n, int mVal, int nVal) {
        return !(m < 0 || m >= mVal || n < 0 || n >= nVal || map[m][n]);
    }

    private static boolean isIn(int m, int n, int k) {
        return getNumsSum(m) + getNumsSum(n) <= k;
    }

    private static int getNumsSum(int val) {
        int modAndDivVal = 10;
        int sum = 0;
        while (val != 0) {
            sum += val % modAndDivVal;
            val /= modAndDivVal;
        }
        return sum;
    }

}
