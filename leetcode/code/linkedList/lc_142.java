package leetcode.code.linkedList;

import leetcode.dataStruct.ListNode;

/**
 * 环形链表II
 * 给定一个链表的头结点，返回链表入环的第一个节点,如果链表无环，则返回 null。（环形链表I，判断链表是否存在环，利用快慢直接即可，存在环则两指针必然会相遇）
 * 思路：快慢指针相遇时，让一个指针指向头结点，然后以相同速速前进，再次相遇地点便是入环的第一个节点(简单的数学推导)
 */
public class lc_142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        boolean isCycle = false;

        // 判断是否有环
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                isCycle = true;
                break;
            }
        }
        // 查找环的入口点
        if (isCycle) {
            while (head != slow) {
                head = head.next;
                slow = slow.next;
            }
            return slow;
        } else {
            return null;
        }

    }

}
