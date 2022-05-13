package leetcode.code;

import leetcode.code.dataStruct.ListNode;

/**
 * 合并两个有序链表
 * 思路：
 * 解法一：递归
 * 解法二: 双指针
 */
public class lc_21 {
    // 解法一：递归
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    // 解法二：双指针
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        // dummy为虚拟头结点，p为前进指针
        ListNode dummy = new ListNode(-1), p = dummy;
        // 双指针遍历两个需要合并的链表
        ListNode p1 = l1, p2 = l2;

        while (p1 != null && p2 != null) {
            // 比较 p1 和 p2 两个指针
            // 将值较小的的节点接到 p 指针
            if (p1.val > p2.val) {
                p.next = p2;
                p2 = p2.next;
            } else {
                p.next = p1;
                p1 = p1.next;
            }
            // p 指针不断前进
            p = p.next;
        }

        // 处理剩下的链表
        if (p1 != null) p.next = p1;
        if (p2 != null) p.next = p2;

        return dummy.next;
    }
}
