package 剑指offer;

import leetcode.A_dataStruct.ListNode;

/**
 * 删除链表的节点
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点
 * 思路：找到对应节点的前一个节点即可
 */
public class jz_18 {
    public ListNode deleteNode(ListNode head, int val) {
        // dummy 节点处理head为null的情况
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while (pre.next != null) {
            if (pre.next.val == val) {
                pre.next = pre.next.next;
                break;
            } else {
                pre = pre.next;
            }
        }
        return dummy.next;
    }
}
