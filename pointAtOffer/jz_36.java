package pointAtOffer;

import leetcode.code.dataStruct.TreeNode;

/**
 * 二叉搜索树与双向链表  doubt
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 * 思路：note 二叉搜索树的中序遍历结果为有序序列
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
        if (cur == null) return;  // 递归出口
        // 递归左子树
        dfs(cur.left);

        // 构建链表
        if (pre == null) {  // 第一个节点
            head = cur;
            pre = head;
        } else {           // 非第一个节点
            pre.right = cur;
            cur.left = pre;
            pre = cur;    // note pre 作为构建链表的指引指针
        }

        // 递归右子树
        dfs(cur.right);
    }
}
