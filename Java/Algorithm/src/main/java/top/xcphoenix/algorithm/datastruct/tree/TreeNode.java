package top.xcphoenix.algorithm.datastruct.tree;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * @author xuanc
 * @version 1.0
 * @date 2020/4/4 下午9:22
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int x) {
        this.val = x;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public static TreeNode buildExample(int[] nodes) {
        if (nodes == null || nodes.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(nodes[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int index = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (index < nodes.length) {
                    TreeNode child = new TreeNode(nodes[index]);
                    node.setLeft(child);
                    queue.add(child);
                }
                if (++index < nodes.length) {
                    TreeNode child = new TreeNode(nodes[index]);
                    node.setRight(child);
                    queue.add(child);
                    index++;
                }
            }
        }

        return root;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TreeNode)) {
            return false;
        }
        TreeNode treeNode = (TreeNode) o;
        return getVal() == treeNode.getVal() &&
                Objects.equals(getLeft(), treeNode.getLeft()) &&
                Objects.equals(getRight(), treeNode.getRight());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVal(), getLeft(), getRight());
    }

}