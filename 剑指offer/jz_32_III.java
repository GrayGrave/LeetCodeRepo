package 剑指offer;

import leetcode.A_dataStruct.TreeNode;

import java.util.*;

/**
 * 从上到下打印二叉树 III
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 * 思路：BFS
 */
public class jz_32_III {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        int count = 0;      // 控制每层的打印方向
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode cur = queue.poll();
                if (count % 2 == 1) {
                    stack.push(cur.val);
                } else {
                    list.add(cur.val);
                }
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
            if (count % 2 == 1) {
                while (!stack.isEmpty()) {
                    list.add(stack.pop());  // 逆向输出
                }
            }
            res.add(new ArrayList<>(list));// res.add(list) x   【和list创建的地方有关，解法2则可以直接add(list)】
            list.clear();
            count++;
        }
        return res;
    }

    /**========================================分割线============================================*/
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> chain = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
                chain.add(cur.val);
            }
            if (flag) {     // 从右往左
                Collections.reverse(chain);
            }
            flag = !flag;
            res.add(chain);
        }
        return res;
    }
}
