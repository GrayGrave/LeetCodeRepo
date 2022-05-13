package 剑指offer;

import leetcode.code.dataStruct.ListNode;

/**
 * 链表中倒数第k个节点
 * 思路：快慢指针
 */
public class jz_22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) return null;
        ListNode low = head;
        ListNode fast = head;

        while (fast != null && k > 0) {
            fast = fast.next;
            k--;
        }
        // 链表节点个数不足K个返回null；
        if (k != 0) return null;
        while (fast != null) {
            fast = fast.next;
            low = low.next;
        }
        return low;
    }
}

