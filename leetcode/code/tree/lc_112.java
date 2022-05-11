package leetcode.code.tree;

import leetcode.A_dataStruct.TreeNode;

/**
 * 路径总和
 * 给你二叉树的根节点root 和一个表示目标和的整数targetSum。判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和targetSum
 * 如果存在，返回 true；否则，返回 false
 */
public class lc_112 {
    /* 解法一、分解问题的思路 */
    // 定义：输入一个根节点，返回该根节点到叶子节点是否存在一条和为 targetSum 的路径
    public boolean hasPathSum(TreeNode root, int sum) {
        return helper(root, sum);
    }

    private boolean helper(TreeNode root, int sum) {
        // base case
        if (root == null) return false;
        if (root.val == sum && (root.left == null && root.right == null)) return true;

        return helper(root.left, sum - root.val) || helper(root.right, sum - root.val);
    }

/**======================================= 分割线 =======================================*/
    /* 解法二、遍历二叉树的思路 */
    int target;
    boolean found = false;
    // 记录遍历过程中的路径和
    int curSum = 0;

    public boolean hasPathSum_2(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        target = targetSum;
        traverse(root);
        return found;
    }

    // 二叉树遍历函数
    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        // 前序遍历位置
        curSum += root.val;
        if (root.left == null && root.right == null) {
            if (curSum == target) {
                found = true;
            }
        }

        traverse(root.left);
        traverse(root.right);

        // 后序遍历位置
        curSum -= root.val;
    }
}
