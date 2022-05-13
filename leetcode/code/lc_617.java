package leetcode.code;

import leetcode.code.dataStruct.TreeNode;

/**
 * 合并二叉树
 * 思路：遍历，二叉树覆盖，都有值则相加
 */
public class lc_617 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;

        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }
}
