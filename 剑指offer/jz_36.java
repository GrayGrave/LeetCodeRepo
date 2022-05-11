package 剑指offer;

import leetcode.A_dataStruct.TreeNode;

/**
 * 二叉搜索树与双向链表
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 * 思路：二叉搜索树的中序遍历结果为有序序列     todo
 */
public class jz_36 {
    private TreeNode pre, head;

    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) return null;

        dfs(root);
        pre.right = head;
        head.left = pre;
        return head;
    }

    //中序遍历
    public void dfs(TreeNode cur) {
        if (cur == null) return;
        dfs(cur.left);

        if (pre != null) pre.right = cur;
        else head = cur;
        cur.left = pre;
        pre = cur;

        dfs(cur.right);
    }
}
