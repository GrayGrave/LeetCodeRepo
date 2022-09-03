package pointAtOffer;

import leetcode.code.dataStruct.TreeNode;

/**
 * 二叉搜索树的第k大节点
 * 给定一棵二叉搜索树，请找出其中第 k 大的节点的值。
 * 思路：二叉搜索树的中序遍历结果是递增序列
 */
public class jz_54 {
    int count = 0;
    int res = 0;

    public int kthLargest(TreeNode root, int k) {
        helper(root, k);
        return res;
    }

    public void helper(TreeNode root, int k) {
        if (root.right != null) {
            helper(root.right, k);
        }
        if (++count == k) {
            res = root.val;
            return;
        }
        if (root.left != null) {
            helper(root.left, k);
        }
    }
}
