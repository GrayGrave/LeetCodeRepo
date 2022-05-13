package leetcode.code;

import leetcode.code.dataStruct.TreeNode;

/**
 * 二叉树的最大深度
 * 思路：
 * 解法一：遍历
 * 解法二：拆解子问题(二叉树递归套路)
 */
public class lc_104 {
    int res = 0;
    int depth = 0;

    // 解法一
    public int maxDepth(TreeNode root) {
        traverse(root);
        return res;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            // 到达叶子节点，更新最大深度
            res = Math.max(res, depth);
            return;
        }
        // 前序位置
        depth++;
        traverse(root.left);
        traverse(root.right);
        // 后序位置
        depth--;
    }


    // 解法二
    public int maxDepth2(TreeNode root) {
        if (root == null) return 0;

        // 获取左右子树信息
        int leftMax = maxDepth2(root.left);
        int rightMax = maxDepth2(root.right);
        // 整理信息并返回
        int res = Math.max(leftMax, rightMax) + 1;
        return res;
    }
}
