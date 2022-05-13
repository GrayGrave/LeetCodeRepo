package leetcode.code;

import leetcode.code.dataStruct.TreeNode;

import java.util.*;

/**
 * 二叉树的右视图
 */
public class lc_199 {
    // 右视图即为层次遍历每一层最后的节点
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 确定每层的节点个数
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer((cur.right));
                //每一层最后的节点值加入list
                if (i == size - 1) res.add(cur.val);
            }
        }
        return res;
    }
}
