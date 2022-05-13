package leetcode.code;

import leetcode.code.dataStruct.ListNode;

/**
 * 环形链表
 * 判断给顶链表是否存在环
 * 思路：快慢指针
 */
public class lc_141 {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }
        return false;
    }
}
