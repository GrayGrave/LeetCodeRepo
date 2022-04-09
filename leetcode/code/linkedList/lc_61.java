package leetcode.code.linkedList;

import leetcode.dataStruct.ListNode;

/**
 * 旋转链表
 * 思路：先将链表成环，然后在合适的地方断开即可,旋转k个，即在原来链表的第(n-k)个位置断开
 */
public class lc_61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        // 获取链表长度
        int n = 1;
        ListNode p = head;
        while (p.next != null) {
            n++;
            p = p.next;
        }

        // 确定断开位置
        int loc = n - (k % n);   // 旋转n个即回到原来的状态
        if (loc == n) return head;

        p.next = head;  // 链表成环   note：这行代码放在确定位置之间，可能会返回循环的链表

        while (loc != 0) {
            p = p.next;
            loc--;
        }
        ListNode res = p.next;
        p.next = null;

        return res;
    }
}
