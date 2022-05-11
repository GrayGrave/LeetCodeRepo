package leetcode.code.linkedList;

import leetcode.A_dataStruct.ListNode;

/**
 * 删除排序链表中的重复元素II   删除其中重复节点
 * 1->2->3->3->4->5  =>  1->2->4->5
 */
public class lc_82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        // 由于链表的头结点可能被删除，故需要构造一个dummy节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {    // 往后面看两步，看看是否有重复的元素
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }

        return dummy.next;  // note： return head，无法正确返回头部有重复元素的case
    }
}
