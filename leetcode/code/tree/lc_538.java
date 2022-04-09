package leetcode.code.tree;

import leetcode.dataStruct.TreeNode;

/**
 * 把二叉搜索树转换为累加树
 * 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树，使每个节点 node 的新值等于原树中大于或等于node.val的值之和。
 * 思路：右-中-左遍历树，然后进行累加更新节点值即可。
 */
public class lc_538 {
    int curSum = 0; // 累加和

    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        midOrder(root);
        return root;
    }

    // 右-中-左遍历树
    public void midOrder(TreeNode root) {
        if (root == null) return;           // base case

        midOrder(root.right);
        root.val = root.val + curSum;    // 更新到该节点的累加和
        curSum = root.val;
        midOrder(root.left);
    }
}
