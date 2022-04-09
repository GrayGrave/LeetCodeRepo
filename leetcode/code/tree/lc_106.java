package leetcode.code.tree;

import leetcode.dataStruct.TreeNode;

import java.util.HashMap;

/**
 * 从中序与后序遍历序列构造二叉树
 * 思路：遍历（前序），即先确定根节点，然后递归建造左右子树。  后序确定根节点，中序确定左右子树结点集合
 *
 */
public class lc_106 {
    // 存储 inorder 中值到索引的映射
    HashMap<Integer, Integer> valToIndex = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            valToIndex.put(inorder[i], i);
        }
        return build(postorder, 0, postorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] postorder, int postStart, int postEnd,
                           int[] inorder, int inStart, int inEnd) {
        // base case
        if (postStart > postEnd) {
            return null;
        }

        // root 节点对应的值就是后序遍历数组的最后一个元素
        int rootVal = postorder[postEnd];
        // rootVal 在中序遍历数组中的索引
        int index = valToIndex.get(rootVal);
        // 左子树节点个数
        int leftSize = index - inStart;
        // 先构造出当前根节点
        TreeNode root = new TreeNode(rootVal);
        // 递归构造左右子树
        root.left = build(postorder, postStart, postStart + leftSize - 1,
                inorder, inStart, index - 1);

        root.right = build(postorder, postStart + leftSize, postEnd - 1,
                inorder, index + 1, inEnd);
        return root;
    }
}
