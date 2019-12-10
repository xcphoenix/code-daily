package top.xcphoenix.algorithm.leetcode.day191126;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

/**
 * middle-of-the-linked-list
 * <p>
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 *
 * @author xuanc
 * @version 1.0
 * @date 2019/11/26 下午1:37
 */
public class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode singleStep = head;
        ListNode doubleStep = head;
        while (doubleStep != null && doubleStep.next != null) {
            singleStep = singleStep.next;
            doubleStep = doubleStep.next.next;
        }
        return singleStep;
    }
}
