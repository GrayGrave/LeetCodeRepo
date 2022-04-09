package algorithmBase.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 树的非递归遍历方式
 */
public class UnRecursiveTraversalBT {

    /***
     * 前序：根-左-右
     * 1) 栈弹出打印
     * 2）如有右，压入右
     * 3）如有左，压入左
     */
    public static void pre(TreeNode head) {
        System.out.println("pre-order: ");

        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                System.out.println(head.value);
                if (head.right != null) stack.push(head.right);
                if (head.left != null) stack.push(head.left);
            }
        }
    }

    /**
     * note: 先序：根-左-右 => 根-右-左 => 逆序(左-右-根)即为后序！！
     * 思路参考先序：
     * 1) 栈弹出放入另一个栈
     * 2）如有左，压入左
     * 3）如有右，压入右
     */
    public static void pos(TreeNode head) {
        System.out.println("post-order: ");

        if (head != null) {
            Stack<TreeNode> s1 = new Stack<>();
            Stack<TreeNode> s2 = new Stack<>();
            s1.push(head);
            while (!s1.isEmpty()) {
                head = s1.pop();
                s2.push(head);
                System.out.println(head.value);         // 根-右-左
                if (head.left != null) s1.push(head.left);
                if (head.right != null) s1.push(head.right);
            }

            while (!s2.isEmpty()) {
                System.out.println(s2.pop().value);      // 左-右-根
            }
        }
    }

    /***
     * 中序：左-根-右
     * 1) 整条左边界依次入栈
     * 2）1）无法继续，弹出打印，来到右子树继续执行 1）
     *
     */
    public static void in(TreeNode head) {
        System.out.println("in-order: ");

        if (head != null) {
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || head != null) {
                if (head != null) {         // 1)
                    stack.push(head);
                    head = head.left;       // 往左窜
                } else {                    // 2)
                    head = stack.pop();
                    System.out.println(head.value);
                    head = head.right;
                }
            }
        }

    }


    // 层次遍历  利用队列
    public static void levelOrderTraversal(TreeNode head) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            System.out.println(head.value);

            if (head.left != null) queue.offer(head.left);
            if (head.right != null) queue.offer(head.right);
        }
    }
}
