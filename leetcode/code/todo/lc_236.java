package leetcode.code.todo;

import leetcode.A_dataStruct.TreeNode;

/**
 * 二叉树的最近公共祖先  git rebase合并原理
 * todo
 */
public class lc_236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) return root;
        return left == null ? right : left;

    }
}
