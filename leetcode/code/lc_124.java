package leetcode.code;

import leetcode.code.dataStruct.TreeNode;

/**
 * 二叉树中的最大路径和 【hard】
 * 思路:
 * 解法一：分析单个节点，路径由节点和左右两条边组成，计算并进行全局的最大路径和更新即可     "以单条链路看问题💡"
 * 解法二：二叉树递归套路，二叉树最大路径稍作修改即可（todo 未走通）
 *
 */
public class lc_124 {
    private int ret = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        getMax(root);
        return ret;
    }

    private int getMax(TreeNode r) {
        if (r == null) return 0;
        // 如果子树路径和为负则应当置0表示最大路径不包含子树
        int left = Math.max(0, getMax(r.left));
        int right = Math.max(0, getMax(r.right));

        // 判断在该节点包含左右子树的路径和是否大于当前最大路径和
        ret = Math.max(ret, r.val + left + right);
        return Math.max(left, right) + r.val;           // 返回以该节点为头的最长路径和
    }
}
