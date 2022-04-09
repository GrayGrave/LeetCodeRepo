package leetcode.code.linkedList;

import leetcode.dataStruct.ListNode;

/**
 * 链表相交
 * 返回两个链表相交的起始位置，没有相交则返回null
 * 思路：双指针
 */
public class lc_160 {
    // 浪漫相遇法
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            // p1 走一步，如果走到 A 链表末尾，转到 B 链表
            if (p1 == null) p1 = headB;
            else p1 = p1.next;

            // p2 走一步，如果走到 B 链表末尾，转到 A 链表
            if (p2 == null) p2 = headA;
            else p2 = p2.next;
        }
        return p1;
    }

}
