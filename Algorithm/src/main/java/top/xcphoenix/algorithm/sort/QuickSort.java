package top.xcphoenix.algorithm.sort;

import java.util.Arrays;

/**
 * @author xuanc
 * @version 1.0
 * @date 2020/3/4 上午9:53
 */
public class QuickSort {

    /**
     * 快排
     *
     * @param arr  待排序数组
     * @param head 待排序起始位置（闭区间）
     * @param tail 待排序末尾位置（闭区间）
     */
    public static void qSort(int[] arr, int head, int tail) {
        // 如果待排序元素为1或数组为空直接返回
        if (head >= tail || arr == null || arr.length <= 1) {
            return;
        }
        int i = head, j = tail, pivot = arr[(head + tail) / 2];
        while (i <= j) {
            // 找到左侧第一个 >= pivot的元素
            while (arr[i] < pivot) {
                i++;
            }
            // 找到右侧第一个 <= pivot的元素
            while (arr[j] > pivot) {
                j--;
            }
            if (i < j) {
                swap(arr, i, j);
                i++;
                j--;
            } else if (i == j) {
                i++;
            }
        }
        qSort(arr, head, j);
        qSort(arr, i, tail);
    }

    /**
     * @see #qSort
     * 基准值策略不同
     */
    public static void qSort2(int[] arr, int head, int tail) {
        if (head >= tail || arr == null || arr.length <= 1) {
            return;
        }
        int i = head, j = tail - 1, pivot = arr[tail];

        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }
            while (j >= 0 && arr[j] > pivot) {
                j--;
            }
            if (i < j) {
                swap(arr, i, j);
                i++;
                j--;
            } else if (i == j) {
                i++;
            }
        }
        swap(arr, i, tail);
        qSort(arr, head, j);
        qSort(arr, i, tail);
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, 0};
        qSort2(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

}
