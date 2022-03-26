package leetcode.code;

import algorithmBase.tree.TreeNode;

import java.util.*;

/**
 * 二叉树的锯齿形层序遍历
 */

public class lc_103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean flag = false;
        while (!queue.isEmpty()) {
            int size = queue.size();                 // 确定每一层的宽度
            List<Integer> chain = new ArrayList<>(); // 记录每一层的遍历结果

            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
                chain.add(cur.value);
            }
            if (flag) {     // 从右往左
                Collections.reverse(chain);
            }
            flag = !flag;
            res.add(new ArrayList<>(chain));
        }

        return res;

    }


}
