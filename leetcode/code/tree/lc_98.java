package leetcode.code.tree;

import leetcode.A_dataStruct.TreeNode;

/**
 * 验证二叉搜索树   todo
 * 左 < 中 < 右
 * 思路:二叉搜索树的中序遍历结果是递增序列
 */
public class lc_98 {
    long pre = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        // 访问左子树
        if (!isValidBST(root.left)) return false;

        // 访问当前节点：如果当前节点小于等于中序遍历的前一个节点，说明不满足BST，返回 false；否则继续遍历。
        if (root.val <= pre) return false;

        pre = root.val;
        // 访问右子树
        return isValidBST(root.right);
    }
}
