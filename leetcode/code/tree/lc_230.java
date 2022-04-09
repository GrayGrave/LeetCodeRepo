package leetcode.code.tree;

import leetcode.dataStruct.TreeNode;

/**
 * 二叉搜索树中第 K 小的元素
 * 思路：二叉搜索树的中序序列即为升序序列
 */
public class lc_230 {
    int res = 0;
    int rank = 0;

    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return res;
    }

    // 中序遍历
    private void traverse(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        traverse(root.left, k);
        rank++;
        if (k == rank) {
            // 找到第 k 小的元素
            res = root.val;
            return;
        }
        traverse(root.right, k);
    }
}
