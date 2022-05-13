package leetcode.code;


import leetcode.code.dataStruct.ListNode;

/**
 * 两数相加      除了0外，两个数都不以0开头
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 708
 * 思路：双指针
 */
public class lc_02 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode n1 = l1, n2 = l2, res = dummy;
        int sum = 0;                            // 记录两数相加结果
        while (n1 != null || n2 != null) {
            sum /= 10;                          // 处理进位
            if (n1 != null) {
                sum += n1.val;
                n1 = n1.next;
            }
            if (n2 != null) {
                sum += n2.val;
                n2 = n2.next;
            }
            res.next = new ListNode(sum % 10);  // 构建结果链表
            res = res.next;
        }

        // 判断最后一位有没有进位
        if (sum / 10 != 0) {
            res.next = new ListNode(1);
        }
        return dummy.next;
    }
}

