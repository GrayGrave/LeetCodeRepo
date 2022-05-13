package 剑指offer;

import leetcode.code.dataStruct.TreeNode;

/**
 * 二叉树的镜像
 */
public class jz_27 {
    public TreeNode mirrorTree(TreeNode root) {
        exchange(root);
        return root;
    }

    // 交换左右子节点，然后递归下去即可
    public void exchange(TreeNode root) {
        if (root == null) return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        exchange(root.left);
        exchange(root.right);
    }
}
