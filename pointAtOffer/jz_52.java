package pointAtOffer;

import leetcode.code.dataStruct.ListNode;

/**
 * 两个链表的第一个公共节点
 */
public class jz_52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode h1 = headA;
        ListNode h2 = headB;
        //null==null  --> true
        while (h1 != h2) {
            h1 = h1 == null ? headB : h1.next;
            h2 = h2 == null ? headA : h2.next;
        }
        return h1;
    }
}

