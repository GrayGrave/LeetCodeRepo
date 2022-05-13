package leetcode.code;

import leetcode.code.dataStruct.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的中序遍历
 */
public class lc_94 {
    /***
     * 中序：左-根-右
     * 1) 整条左边界依次入栈
     * 2）1）无法继续，弹出打印，来到右子树继续执行 1）
     *
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        // 利用栈实现非递归遍历
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {         // 1)
                stack.push(root);
                root = root.left;       // 往左窜
            } else {                    // 2)
                root = stack.pop();
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }
}
