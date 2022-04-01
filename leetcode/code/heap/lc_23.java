package leetcode.code.heap;

import leetcode.dataStruct.ListNode;

import java.util.PriorityQueue;

/**
 * 合并 K 个升序链表
 * 思路：堆
 */
public class lc_23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];

        // 小根堆 note: 建立堆别忘了传入比较器，即堆中的元素该根据何种规则进行排序
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> a.val - b.val);
        ListNode res = new ListNode(0);           // 虚拟头结点 (dummy节点)，值随便设置
        ListNode cur = res;

        for (ListNode head : lists) {
            if (head != null) heap.offer(head);
        }

        while (!heap.isEmpty()) {
            ListNode node = heap.poll();
            if (node.next != null) heap.offer(node.next);
            cur.next = node;
            cur = node;
        }
        return res.next;
    }
}
