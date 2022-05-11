package leetcode.code.linkedList;

import leetcode.A_dataStruct.ListNode;

/**
 * 删除链表的倒数第 N 个节点
 * 思路：快慢指针
 */
public class lc_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 虚拟头结点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        // 找倒数第 n + 1 个节点
        ListNode x = findFromEnd(dummy, n + 1);
        // 删掉倒数第 n 个节点
        x.next = x.next.next;

        return dummy.next;
    }

    // 返回链表的倒数第 k 个节点
    private ListNode findFromEnd(ListNode head, int k) {
        ListNode p1 = head, p2 = head;

        // p1 先走 k 步
        for (int i = 0; i < k; i++) p1 = p1.next;

        // p1 和 p2 同时走 n - k 步
        while (p1 != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        // p2 现在指向第 n - k 个节点
        return p2;
    }
}
