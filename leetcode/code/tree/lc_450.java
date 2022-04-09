package leetcode.code.tree;

import leetcode.dataStruct.TreeNode;

/**
 * 删除二叉搜索树中的节点    返回删除节后的二叉树的根节点引用
 * 思路：删除节点分三种情况
 * 1、该节点为叶子节点，直接删除即可
 * 2、该节点拥有一个子节点，直接让子节点接替该节点
 * 3、该节点拥有两个子节点，让右子树的最小节点来接替该位置
 */
public class lc_450 {
    // 数据结构基本操作
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key) {
            // 这两个 if 把情况 1 和 2 都正确处理了
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            // 处理情况 3
            // 获得右子树最小的节点
            TreeNode minNode = getMin(root.right);

            // 删除右子树最小的节点
            root.right = deleteNode(root.right, minNode.val);

            // 用右子树最小的节点替换 root 节点    note：巧妙！
            minNode.left = root.left;
            minNode.right = root.right;
            root = minNode;

        } else if (root.val > key) {                     // 往左边查找
            root.left = deleteNode(root.left, key);
        } else {                                         // 往右边查找
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    private TreeNode getMin(TreeNode node) {
        // BST 最左边的就是最小的
        while (node.left != null) node = node.left;
        return node;
    }

}
