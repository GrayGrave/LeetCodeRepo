package pointAtOffer;

/**
 * 复杂链表的复制
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，
 * 还有一个 random 指针指向链表中的任意节点或者 null。
 * 思路：
 * 第一步：根据原始链表的每个节点 N 创建对应的 N'
 * 第二步：将原始节点的 random 指向，复制到新节点之间的random指向。
 * 第三步：断开两个链表即获得两个一样的链表。note (模具脱模)
 */
public class jz_35 {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        //构建新旧交替链
        Node newHead = head;
        while (newHead != null) {
            Node newOne = new Node(newHead.val);
            newOne.next = newHead.next;
            newHead.next = newOne;
            newHead = newOne.next;
        }
        //处理random
        newHead = head;
        while (newHead != null) {
            if (newHead.random != null) {
                newHead.next.random = newHead.random.next;
            }
            newHead = newHead.next.next;
        }
        //断开两个链表
        Node cur = head;
        Node res = head.next;
        while (cur != null) {
            Node next = cur.next.next;
            Node curCopy = cur.next;                // cur 拖着curCopy往后走

            cur.next = next;
            curCopy.next = next != null ? next.next : null;
            cur = next;
        }
        return res;
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
