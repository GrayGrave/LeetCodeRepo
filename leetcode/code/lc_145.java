package leetcode.code;

import leetcode.code.dataStruct.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的后序遍历
 */
public class lc_145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        /**
         * note: 先序：根-左-右 => 根-右-左 => 逆序(左-右-根)即为后序！！
         * 思路参考先序：
         * 1) 栈弹出放入另一个栈
         * 2）如有左，压入左
         * 3）如有右，压入右
         */
        List<Integer> res = new ArrayList<>();
        if (root != null) {
            Stack<TreeNode> s1 = new Stack<>();
            Stack<TreeNode> s2 = new Stack<>();
            s1.push(root);
            while (!s1.isEmpty()) {
                root = s1.pop();
                s2.push(root);

                if (root.left != null) s1.push(root.left);
                if (root.right != null) s1.push(root.right);
            }

            while (!s2.isEmpty()) {
                res.add(s2.pop().val);
            }
        }
        return res;
    }
}

