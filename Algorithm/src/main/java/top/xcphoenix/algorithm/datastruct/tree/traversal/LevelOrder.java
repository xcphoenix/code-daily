package top.xcphoenix.algorithm.datastruct.tree.traversal;

import java.util.*;

/**
 * @author      xuanc
 * @date        2020/3/4 上午10:45
 * @version     1.0
 */
public class LevelOrder {

    public static List<List<Integer>> solution(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return result;
        }

        queue.offer(root);
        List<Integer> first = new ArrayList<>();
        first.add(root.val);
        result.add(first);

        solve(result, queue);
        return result;
    }

    private static void solve(List<List<Integer>> result, Queue<TreeNode> queue) {
        int num = queue.size();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            addTree(queue, list);
        }
        if (!list.isEmpty()) {
            result.add(list);
        }
        if (!queue.isEmpty()) {
            solve(result, queue);
        }
    }

    private static void addTree(Queue<TreeNode> queue, List<Integer> list) {
        TreeNode node = queue.poll();
        if (node != null) {
            if (node.left != null) {
                queue.offer(node.left);
                record(list, node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
                record(list, node.right);
            }
        }
    }

    private static void record(List<Integer> lists, TreeNode node) {
        lists.add(node.val);
    }

    public static void main(String[] args) {
        TreeNode node = TreeNode.buildExample(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        System.out.println(solution(node));
    }

}