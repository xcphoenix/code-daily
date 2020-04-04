package top.xcphoenix.algorithm.datastruct.tree.traversal;

import sun.reflect.generics.tree.Tree;

import java.util.Stack;

/**
 * @author      xuanc
 * @date        2020/4/4 下午10:12
 * @version     1.0
 */ 
public class OrderTree {

    static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode parent = stack.pop();
            System.out.println(parent.getVal());
            if (parent.getRight() != null) {
                stack.push(parent.getRight());
            }
            if (parent.getLeft() != null) {
                stack.push(parent.getLeft());
            }
        }
    }

    static void midOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {

            // 左子树走到头
            while (root != null && root.getLeft() != null) {
                root = root.getLeft();
                stack.push(root);
            }

            // 开始取出最左的节点，放入节点的右子树
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                System.out.println(node.getVal());
                if ((node = node.getRight()) != null) {
                    stack.push(node);
                    root = node;
                    break;
                }
            }
        }

    }

    static void afterOrder(TreeNode root) {
        
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.buildExample(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9});
        // preOrder(root);
        // midOrder(root);
    }

}
