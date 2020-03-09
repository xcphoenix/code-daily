package top.xcphoenix.algorithm.sort;

import java.util.Arrays;

/**
 * @author      xuanc
 * @date        2020/2/25 下午10:20
 * @version     1.0
 */ 
public class MergeSort {

    public static void main(String[] args) {
        int[] data = new int[]{-6, 7, 9, 3, 8, 4, 6, 10, 9};
        mergeSort(data);
        System.out.println(Arrays.toString(data));
    }

    static void mergeSort(int[] data) {
        sort(data, 0, data.length - 1, new int[data.length]);
    }

    static void sort(int[] data, int left, int right, int[] bk) {
        if (left >= right) {
            return;
        }
        int center = (left + right) / 2;
        sort(data, left, center, bk);
        sort(data, center + 1, right, bk);
        merge(data, bk, left, center, right);
    }

    static void merge(int[] data, int[] bk, int left, int center, int right) {
        int leftIndex = left;
        int rightIndex = center + 1;
        int mergeIndex = left;
        while (leftIndex <= center && rightIndex <= right) {
            if (data[leftIndex] > data[rightIndex]) {
                bk[mergeIndex] = data[rightIndex];
                rightIndex++;
            } else {
                bk[mergeIndex] = data[leftIndex];
                leftIndex++;
            }
            mergeIndex++;
        }
        if (leftIndex <= center) {
            System.arraycopy(data, leftIndex, bk, mergeIndex, center - leftIndex + 1);
        }
        if (rightIndex <= right) {
            System.arraycopy(data, rightIndex, bk, mergeIndex, right - rightIndex + 1);
        }
        System.arraycopy(bk, left, data, left, right - left + 1);
    }

}
