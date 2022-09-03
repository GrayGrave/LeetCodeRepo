package pointAtOffer;

import leetcode.code.dataStruct.TreeNode;

/**
 * 平衡二叉树
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 * 思路：二叉树递归套路（左程云总结）
 */
public class jz_55_II {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root).isBT;
    }

    public ReturnType helper(TreeNode root) {
        if (root == null) {
            return new ReturnType(0, true);
        }
        ReturnType left = helper(root.left);
        ReturnType right = helper(root.right);
        int height = Math.max(left.height, right.height) + 1;
        boolean isBT = left.isBT && right.isBT && Math.abs(left.height - right.height) <= 1;
        return new ReturnType(height, isBT);
    }

    static class ReturnType {
        int height;
        boolean isBT;

        public ReturnType(int height, boolean isBT) {
            this.height = height;
            this.isBT = isBT;
        }
    }
}
