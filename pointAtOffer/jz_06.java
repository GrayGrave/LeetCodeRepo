package pointAtOffer;

import leetcode.code.dataStruct.ListNode;

import java.util.Stack;

/**
 * 从尾到头打印打印链表
 * 思路：利用栈
 */
public class jz_06 {
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        int index = 0;
        while (!stack.isEmpty()) {
            res[index++] = stack.pop();
        }
        return res;
    }
}
