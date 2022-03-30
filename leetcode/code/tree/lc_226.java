package leetcode.code.tree;

import leetcode.dataStruct.TreeNode;

import java.util.Stack;

/**
 * 翻转二叉树
 * 思路：
 * 解法一：递归套路
 * 解法二：非递归，利用栈实现
 */
public class lc_226 {
    public TreeNode invertTree(TreeNode root) {
        helper(root);
        return root;
    }

    private void helper(TreeNode root) {
        if (root == null) return;

        // 处理左右子树
        helper(root.left);
        helper(root.right);

        // 处理当前节点
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }

    /**
     * ========================================= 分割线  ========================================
     */

    // 利用栈实现非递归解法   note 深入理解与使用队列实现BFS的本质区别
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            // 交换cur的左右子树
            TreeNode tmp = cur.left;
            cur.left = cur.right;
            cur.right = tmp;

            if (cur.left != null) stack.push(cur.left);
            if (cur.right != null) stack.push(cur.right);
        }
        return root;
    }

}
