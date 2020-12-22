package top.xcphoenix.algorithm.netease.three;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author xuanc
 * @version 1.0
 */
public class Solution {

    private int res;

    /**
     * @param boxes int整型二维数组
     * @return int整型
     */
    public int maxBoxes(int[][] boxes) {
        Comparator<int[]> comparator = (o1, o2) -> o2[0] - o1[0];
        Arrays.sort(boxes, comparator);

        res = 1;
        for (int i = 0; i < boxes.length; i++) {
            dfs(boxes, boxes[i], i + 1, 1);
        }
        return res;
    }

    void dfs(int[][] boxes, int[] lastBox, int depth, int tmpRes) {
        if (depth >= boxes.length) {
            res = Math.max(tmpRes, res);
            return;
        }
        // 不选
        dfs(boxes, lastBox, depth + 1, tmpRes);

        // 选
        int[] thisBox = boxes[depth];
        boolean flag = true;
        for (int m = 0; m < 3; m++) {
            if (lastBox[m] <= thisBox[m]) {
                flag = false;
                break;
            }
        }
        if (flag) {
            // 放得下
            dfs(boxes, thisBox, depth + 1, tmpRes + 1);
        }
    }

    public static void main(String[] args) {
        int[][] boxes = new int[][]{
                {5, 4, 3}, {5, 4, 5}, {6, 6, 6}
        };
        int k = new Solution().maxBoxes(boxes);
        System.out.println(k);
    }

}
