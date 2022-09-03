package pointAtOffer;

import leetcode.code.dataStruct.TreeNode;

/**
 * 树的子结构
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 * 思路：
 * 若树 BB 是树 AA 的子结构，则子结构的根节点可能为树 AA 的任意一个节点。因此，判断树 BB 是否是树 AA 的子结构，需完成以下两步工作：
 * 1）【先序】遍历树 AA 中的每个节点 n_An；（对应函数 isSubStructure(A, B)）
 * 2）判断树 AA 中 以 n_An 为根节点的子树是否包含树 BB 。（对应函数 recur(A, B)）
 */
public class jz_26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B)
                || isSubStructure(A.right, B));
    }

    boolean recur(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A == null || A.val != B.val) return false;
        return recur(A.left, B.left) && recur(A.right, B.right);
    }
}
