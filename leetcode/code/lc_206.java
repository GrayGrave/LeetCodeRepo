package leetcode.code;

import leetcode.code.dataStruct.ListNode;

/**
 * 反转链表
 * 思路：迭代
 */
public class lc_206 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTmp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = nextTmp;
        }
        return pre;
    }
}
