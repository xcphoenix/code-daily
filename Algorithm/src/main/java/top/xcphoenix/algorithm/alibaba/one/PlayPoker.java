package top.xcphoenix.algorithm.alibaba.one;

/**
 * @author xuanc
 * @version 1.0
 * @date 2020/3/21 下午3:53
 */
public class PlayPoker {

    int min = Integer.MAX_VALUE;
    int[] poker;

    public int getCount(int[] arr) {
        poker = arr;
        backtrace(0, 0);
        return min;
    }

    public void backtrace(int n, int count) {
        // 莫得牌了
        if (n >= 10) {
            // 保存最小的次数
            min = Math.min(min, count);
            return;
        }
        // 没有牌，直接看下一张
        if (poker[n] == 0) {
            backtrace(n + 1, count);
            return;
        }
        int one = getContinue(n);
        int two = getTwoContinue(n);
        // 可以打顺子
        if (one > 0) {
            // 拿走顺子
            divide(n, 1, 5);
            backtrace(n, count + 1);
            // 放回来
            add(n, 1, 5);
        }
        // 可以打连对
        if (two > 0) {
            // 拿走连对
            divide(n, 2, 3);
            backtrace(n, count + 1);
            // 放回来
            add(n, 2, 3);
        }
        // 可以打对子
        if (poker[n] >= 2) {
            poker[n] -= 2;
            backtrace(n, count + 1);
            poker[n] += 2;
            return;   //因为能打对子就不会打单张，此时return
        }
        // 单张
        {
            poker[n]--;
            backtrace(n, count + 1);
            poker[n]++;
        }
    }

    /** 判断顺子 */
    public int getContinue(int n) {
        // 后面的4种牌凑不够五张
        if (n + 1 > 6) {
            return 0;
        }
        int min = 5;
        // 看后面的５张牌
        for (int i = n; i < n + 5; i++) {
            min = Math.min(min, poker[i]);
        }
        return min;
    }

    /** 判断连对 */
    public int getTwoContinue(int n) {
        // 后面的两种牌凑不够三连对
        if (n + 1 > 8) {
            return 0;
        }
        int min = 5;
        // 看后面的３张牌
        for (int i = n; i < n + 3; i++) {
            min = Math.min(min, poker[i] / 2);
        }
        return min;

    }

    public void divide(int n, int count, int time) {
        for (int i = n; i < n + time; i++) {
            poker[i] = poker[i] - count;
        }
    }

    public void add(int n, int count, int time) {
        for (int i = n; i < n + time; i++) {
            poker[i] = poker[i] + count;
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 4, 4, 4, 4, 4, 4, 4, 4, 4};
        System.out.println(new PlayPoker().getCount(arr));
    }

}