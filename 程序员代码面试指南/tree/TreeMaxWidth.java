package 程序员代码面试指南.tree;

import algorithmBase.tree.TreeNode;

import java.util.*;

/**
 * 计算二叉树的最大宽度
 */

public class TreeMaxWidth {
    public static int treeMaxWidth(TreeNode head) {
        int res = 0;
        if (head == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(head);

        while (!queue.isEmpty()) {
            int size = queue.size();                 // 确定每一层的宽度
            res = Math.max(res, size);               // 更新最大宽度
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
        }
        return res;
    }
}









