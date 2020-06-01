package top.xcphoenix.algorithm.sort;

import java.util.Arrays;

/**
 * @author      xuanc
 * @date        2020/3/4 上午9:25
 * @version     1.0
 */ 
public class HeapSort {

    private int[] arr;
    public HeapSort(int[] arr) {
        this.arr = arr;
    }

    public void sort() {
        int len = arr.length - 1;
        // 第一个非根节点
        int beginIndex = (arr.length >> 1) - 1;
        // 遍历非根节点
        for (int i = beginIndex; i >= 0; i--) {
            maxHeapify(i, len);
        }

        // 依次获取最大值，将最大值放在数组最后，并维护堆的性质
        for (int i = len; i > 0; i--) {
            swap(0, i);
            maxHeapify(0, i - 1);
        }
    }

    private void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 维护最大堆性质
     * @param index 开始
     * @param len 结尾
     */
    private void maxHeapify(int index, int len) {
        // 左子节点
        int li = (index << 1) + 1;
        // 右子节点
        int ri = li + 1;
        int cMax = li;
        // 如果为叶子节点，直接返回
        if (li > len) {
            return;
        }

        // 找到孩子节点中最大值的下标
        if (ri <= len && arr[ri] > arr[li]) {
            cMax = ri;
        }
        // 若父节点小于子节点最大值
        if (arr[cMax] > arr[index]) {
            // 交换
            swap(cMax, index);
            // 维护换下后的子树
            maxHeapify(cMax, len);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {3, 5, 3, 86, 8, 6, 1, 5, 8, 6, 2, 4, 9, 4, 7, 0, 1, 8, 9, 7, 3, 1, 2, 5, 9, 7, 4, 0, 2, 6};
        new HeapSort(arr).sort();
        System.out.println(Arrays.toString(arr));
    }

}
