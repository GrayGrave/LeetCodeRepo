package ac.tree;

import algorithmBase.tree.TreeNode;

/**
 * 判断是否是平衡树，即任何子树左右高度差不超过1
 * 思路：
 * 递归判顶条件为：左右子树都是平衡树 && 左右子树高度差不超过1
 */

public class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root).isBT;
    }

    public Info helper(TreeNode root) {
        if (root == null) {
            return new Info(0, true);
        }
        Info left = helper(root.left);  // 1、从左子树获取信息
        Info right = helper(root.right);// 2、从右子树获取信息

        // 3、整理并返回信息
        int height = Math.max(left.height, right.height) + 1;
        boolean isBT = left.isBT && right.isBT && Math.abs(left.height - right.height) <= 1;

        return new Info(height, isBT);
    }

    static class Info {
        int height;
        boolean isBT;

        public Info(int height, boolean isBT) {
            this.height = height;
            this.isBT = isBT;
        }
    }
}
