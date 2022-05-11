package leetcode.code.tree;

import leetcode.A_dataStruct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层序遍历
 * 思路：BFS
 */
public class lc_102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> chain = new ArrayList<>();
            // 处理一层的节点,从左向右遍历
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                chain.add(cur.val);
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
            // 将一层的遍历结果进行收集
            res.add(chain);
        }
        return res;
    }
}
