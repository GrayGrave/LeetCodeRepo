package leetcode.code.tree;

import leetcode.dataStruct.TreeNode;

import java.util.*;

/**
 * 二叉树的锯齿形层序遍历
 * 思路：BFS
 */
public class lc_103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // 标识层间遍历的方向
        boolean toRight = true;
        while (!queue.isEmpty()) {
            int size = queue.size();                    // 确定每一层的宽度
            List<Integer> chain = new ArrayList<>();    // 记录每一层的结果
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                chain.add(cur.val);
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            if (!toRight) {
                Collections.reverse(chain);
            }
            res.add(chain);
            // 改变下一层的遍历方向
            toRight = !toRight;
        }
        return res;
    }
}
