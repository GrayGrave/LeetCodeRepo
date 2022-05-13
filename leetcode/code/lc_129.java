package leetcode.code;

import leetcode.code.dataStruct.TreeNode;

/**
 * 求根到叶子节点数字之和
 * 树中每个节点都存放有一个 0 到 9 之间的数字。根节点到每个叶子节点拼接起来一个数字，求所有这种数字之和。
 * 思路: 遍历 （涉及轨迹-> 回溯，注意决策树最顶层是不是[],决定摘取合适chain的时机）
 */
public class lc_129 {
    StringBuilder path = new StringBuilder();
    int res = 0;

    public int sumNumbers(TreeNode root) {
        traverse(root);
        return res;
    }

    // 遍历二叉树
    private void traverse(TreeNode root) {
        if (root == null) return;

        path.append(root.val);
        if (root.left == null && root.right == null) {
            res += Integer.parseInt(path.toString());
        }

        // 两个候选节点
        traverse(root.left);
        traverse(root.right);
        // 撤销节点值，即回溯
        path.deleteCharAt(path.length() - 1);
    }

    /**=============================== 分割线 ===================================*/
    // 回溯模板
    public int sumNumbers2(TreeNode root) {
        if (root == null) return 0;
        int[] res = new int[1];
        dfs(root, 0, res);
        return res[0];
    }

    private void dfs(TreeNode root, int chain, int[] res) {
        // 截止条件
        if (root.left == null && root.right == null) {
            res[0] += chain * 10 + root.val;
            return;
        }
        // 候选节点  note：(压入弹出的"回溯过程"，直接dfs的参数中体现了，因为两次dfs入参chain都和上一层dfs传入的chain一样)
        if (root.left != null) dfs(root.left, chain * 10 + root.val, res);
        if (root.right != null) dfs(root.right, chain * 10 + root.val, res);
    }


}
