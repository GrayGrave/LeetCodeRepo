package 剑指offer;

import leetcode.code.dataStruct.TreeNode;

import java.util.*;

/**
 * 从上到下打印二叉树 II
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 * 思路：BFS
 */
public class jz_32_II {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();        // 获取每一层的节点数
            for (int i = 0; i < n; i++) {
                TreeNode cur = queue.poll();
                list.add(cur.val);
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
            res.add(list);
            list.clear();           // 清除一层的信息，继续记录下一层的信息
        }
        return res;
    }
}
