package leetcode.code.tree;

import leetcode.dataStruct.TreeNode;

/**
 * 对称二叉树
 * 判断是否为对称二叉树，即是否为镜像二叉树
 * 思路：
 * 树对称-> 左子树与右子树镜像对称：1）他们的根节点具有相同的值 2）每个树的右子树都与另一个树的左子树镜像对称   todo
 * 解法一：对称二叉树的左中右遍历与右中左遍历顺序一样
 * 解法二：递归
 */
public class lc_101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return check(root.left, root.right);
    }

    // 检查两棵树是否对称
    private boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null || left.val != right.val) return false;

        return check(left.left, right.right) && check(left.right, right.left);
    }
}
