package leetcode.code.tree;

import leetcode.dataStruct.TreeNode;

/**
 * 二叉树的最大深度
 * 思路：二叉树递归套路
 */
public class lc_104 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        // 获取左右子树信息
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        // 整理信息并返回
        int res = Math.max(leftMax, rightMax) + 1;
        return res;
    }
}
