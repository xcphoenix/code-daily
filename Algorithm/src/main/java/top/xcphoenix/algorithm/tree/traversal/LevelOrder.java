package top.xcphoenix.algorithm.tree.traversal;

import com.sun.source.tree.Tree;

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
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);
        System.out.println(solution(node));
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        this.val = x;
    }
}