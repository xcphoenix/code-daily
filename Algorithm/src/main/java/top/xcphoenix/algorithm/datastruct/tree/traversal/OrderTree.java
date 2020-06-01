package top.xcphoenix.algorithm.datastruct.tree.traversal;

import top.xcphoenix.algorithm.datastruct.tree.TreeNode;

import java.util.Stack;

/**
 * @author xuanc
 * @version 1.0
 * @date 2020/4/4 下午10:12
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
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root, lastNode = null;

        while (cur != null || !stack.isEmpty()) {

            // 左子树走到最后
            while (cur != null) {
                stack.push(cur);
                cur = cur.getLeft();
            }

            // 左子树不能再走了，接下来要么处理右子树要么处理根
            // 左孩子：取出左子树、指向右子树以便遍历
            // 右孩子：取出节点，返回根
            while (!stack.isEmpty()) {
                cur = stack.pop();

                // 根节点：没有右孩子，右孩子已经遍历过了
                if (cur.getRight() == null || cur.getRight() == lastNode) {
                    System.out.println(cur.getVal());
                    // 因为是后序：left -> right -> root，
                    // 所以处理 root 的前提是左子树和右子树都遍历完
                    //
                    // 当取出一个节点时，是处理这个节点还是处理节点的右子树（左子树在第一个while中处理完了）
                    // 取决于有没有右子树或者右子树有没有处理完，那么就需要区分处理完右子树和未处理右子树这两个情况。
                    // 由于右子树总是先于根节点遍历，当右子树遍历完毕后，即 root->rightChild 被处理（这个节点是右子树的根节点，当他被处理
                    // 意味着右子树都被处理完毕），就可以处理根节点，最简单的办法就是使用一个值去保存右子树的根节点，如果保存了该节点，意味着
                    // 处理了右子树。
                    //
                    // 同样的，对根节点的处理发生在处理完毕右子树之后，当右子树的根节点被处理完毕，会回溯到其父节点，父节点通过 lastNode 来判断
                    // 右子树有没有被访问
                    //
                    // 更新最近访问的节点
                    lastNode = cur;
                    cur = null;
                }
                // 处理右子树
                else {
                    // 根要在右子树处理完再访问，还得放回去
                    stack.push(cur);
                    cur = cur.getRight();
                    break;
                }
            }
        }

    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.buildExample(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        // preOrder(root);
        // midOrder(root);
        afterOrder(root);
    }

}
