package leetcode.code.linkedList;

import leetcode.dataStruct.ListNode;

/**
 * 两两交换链表中的节点
 * 1->2->3->4->5   =>  2->1->4->3->5
 */
public class lc_24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode l1 = dummy;      // 定一点，交换后面的两个节点
        ListNode l2 = head;

        while (l2 != null && l2.next != null) {
            ListNode nextStart = l2.next.next;
            l1.next = l2.next;
            l2.next.next = l2;
            l2.next = nextStart;

            // 进行下一组的节点交换
            l1 = l2;
            l2 = nextStart;
        }
        return dummy.next;
    }

}
