package leetcode.code.linkedList;

import leetcode.dataStruct.ListNode;

/**
 * K 个一组翻转链表   note: ‼️coding检验题型
 * 思路：不断向前划分好翻转区间，依次进行翻转
 */
public class lc_25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode end = dummy;

        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) end = end.next;     // 确定k个一组翻转的区间[start,end]
            if (end == null) break;                                 // 凑不齐一个翻转区间，直接退出

            ListNode start = pre.next;
            ListNode next = end.next;               // 为下一个翻转区间引路

            end.next = null;                          // 断开，专注于该区间的翻转
            pre.next = reverse(start);                // 一个区间翻转完成，上一个区间末尾与该区间头部连接

            start.next = next;                        // 该区间末尾与下一区间的头结点相连

            // 重新初始化pre与end进行下一区间的翻转
            pre = start;
            end = start;
        }
        return dummy.next;
    }

    // 翻转给定的链表，返回翻转后链表的头部结点
    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }
}
