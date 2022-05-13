package leetcode.code;

import leetcode.code.dataStruct.ListNode;

/**
 * 删除排序链表中的重复元素   不删除其中重复节点
 * 1->2->3->3->4->5  =>  1->2->3->4->5
 */
public class lc_83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode slow = head, fast = head;
        while (fast != null) {
            if (fast.val != slow.val) {
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        // slow断开与后面重复元素的连接
        slow.next = null;
        return head;
    }
}
