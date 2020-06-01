package top.xcphoenix.algorithm.leetcode;

import javafx.util.Pair;

import java.util.*;

/**
 * @author xuanc
 * @version 1.0
 * @date 2020/3/21 下午4:24
 */
public class Solution365 {

    private Set<Pair<Integer, Integer>> save;
    private Stack<int[]> stack;
    private int[] cap;
    private boolean success = false;

    public boolean canMeasureWater(int x, int y, int z) {
        save = new HashSet<>();
        cap = new int[]{x, y};
        stack = new Stack<>();
        stack.push(new int[]{0, 0});
        dfs(z);
        return success;
    }

    void dfs(int z) {
        while (!stack.isEmpty()) {
            int[] now = stack.pop();

            call(fill(now, 0), z);
            call(fill(now, 1), z);
            call(clear(now, 0), z);
            call(clear(now, 1), z);
            call(poll(now, 0, 1), z);
            call(poll(now, 1, 0), z);
        }
    }

    void call(int[] kettle, int z) {
        Pair<Integer, Integer> node = new Pair<>(kettle[0], kettle[1]);
        if (success || save.contains(node)) {
            return;
        } else if (kettle[0] == z || kettle[1] == z || kettle[0] + kettle[1] == z) {
            success = true;
            return;
        } else {
            stack.push(kettle);
            save.add(node);
        }
    }

    int[] fill(int[] kettle, int index) {
        int[] newKettle = new int[kettle.length];
        System.arraycopy(kettle, 0, newKettle, 0, kettle.length);
        newKettle[index] = cap[index];
        return newKettle;
    }

    int[] clear(int[] kettle, int index) {
        int[] newKettle = new int[kettle.length];
        System.arraycopy(kettle, 0, newKettle, 0, kettle.length);
        newKettle[index] = 0;
        return newKettle;
    }

    int[] poll(int[] kettle, int from, int to) {
        int[] newKettle = new int[kettle.length];
        System.arraycopy(kettle, 0, newKettle, 0, kettle.length);

        int avaCap;
        if (newKettle[from] > (avaCap = cap[to] - newKettle[to])) {
            newKettle[from] -= avaCap;
            newKettle[to] = cap[to];
        } else {
            newKettle[to] += newKettle[from];
            newKettle[from] = 0;
        }
        return newKettle;
    }

    public static void main(String[] args) {
        int x = 104579;
        int y = 104593;
        int z = 12444;
        System.out.println(new Solution365().canMeasureWater(x, y, z) ? "True" : "False");
    }

}
