package leetcode.code.tree;

import leetcode.dataStruct.TreeNode;

/**
 * 二叉树展开为链表
 * 展开为先序遍历的顺序，left指针置为空
 *
 * 思路: 递归拆解问题
 * 对于一个节点 x，可以执行以下流程：
 * 1、先利用 flatten(x.left) 和 flatten(x.right) 将 x 的左右子树拉平。
 * 2、将 x 的右子树接到左子树下方，然后将整个左子树作为右子树。
 */
public class lc_114 {
    // 定义：将以 root 为根的树拉平为链表
    public void flatten(TreeNode root) {
        // base case
        if (root == null) return;

        // 利用定义，把左右子树拉平
        flatten(root.left);
        flatten(root.right);

        /**** 后序遍历位置 ****/
        // 1、左右子树已经被拉平成一条链表
        TreeNode left = root.left;
        TreeNode right = root.right;

        // 2、将左子树作为右子树
        root.left = null;
        root.right = left;

        // 3、将原先的右子树接到当前右子树的末端
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
    }

}
