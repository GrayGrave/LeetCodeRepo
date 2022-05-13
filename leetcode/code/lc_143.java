package leetcode.code;

import leetcode.code.dataStruct.ListNode;

/**
 * 重排链表
 * l0->l1->l2->...->ln-1->ln  排序为 l0->ln-l1->ln-1->...
 * 思路：
 * 解法一:借助List获取所有元素，然后重建链表（额外空间复杂度O(N)）
 * 解法二：1）寻找链表中间节点 2)后半段链表逆序 3）合并链表     note：字节-幸福里团队面试题
 */
public class lc_143 {
    //解法二
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode mid = middleNode(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;
        mid.next = null;
        l2 = reverseList(l2);
        mergeList(l1, l2);
    }

    // 寻找链表中间节点
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // 反转链表
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = nextTemp;
        }
        return pre;
    }

    // 合并链表
    public void mergeList(ListNode l1, ListNode l2) {
        ListNode l1_nxt;
        ListNode l2_nxt;
        while (l1 != null && l2 != null) {
            l1_nxt = l1.next;
            l2_nxt = l2.next;

            l1.next = l2;
            l1 = l1_nxt;

            l2.next = l1;
            l2 = l2_nxt;
        }
    }
}



