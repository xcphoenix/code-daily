package top.xcphoenix.algorithm.sort;

import java.util.Arrays;

import static top.xcphoenix.algorithm.sort.MergeSort.merge;

/**
 * @author      xuanc
 * @date        2020/3/1 下午3:39
 * @version     1.0
 */ 
public class MergeSortV2 {

    public static void main(String[] args) {
        int[] data = new int[]{-6, 7, 9, 3, 8, 4, 6, 10, 9};
        mergeSort(data);
        System.out.println(Arrays.toString(data));
    }

    static void mergeSort(int[] data) {
        int len = 1;
        while (len < data.length) {
            mergePass(data, len);
            len *= 2;
        }
    }

    static void mergePass(int[] data, int depth) {
        int now = 0;
        // 处理前面成对的
        while (now + 2 * depth <= data.length) {
            int mid = now + depth - 1;
            int end = now + 2 * depth - 1;
            merge(data, new int[data.length], now, mid, end);
            now += 2 * depth;
        }
        // 处理剩余的两个分组，如果只有一个不需要合并
        if (now + depth < data.length) {
            merge(data, new int[data.length], now, now + depth - 1, data.length - 1);
        }
    }

}
