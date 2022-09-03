package pointAtOffer;

import leetcode.code.dataStruct.TreeNode;

/**
 * 对称的二叉树
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 * 思路：
 * note 对称二叉树定义： 对于树中任意两个对称节点 L 和 R ，一定有：
 * L.val = R.val：即此两对称节点值相等。
 * L.left.val = R.right.val ：即 L 的左子节点 和 R 的右子节点对称；
 * L.right.val = R.left.val ：即 L 的右子节点 和 R 的左子节点对称。
 * 根据以上规律，考虑从顶至底递归，判断每对节点是否对称，从而判断树是否为对称二叉树。
 *
 */
public class jz_28 {
    public boolean isSymmetric(TreeNode root) {
        return root == null || recur(root.left, root.right);
    }

    boolean recur(TreeNode L, TreeNode R) {
        if (L == null && R == null) return true;
        if (L == null || R == null || L.val != R.val) return false;
        return recur(L.left, R.right) && recur(L.right, R.left);
    }
}
