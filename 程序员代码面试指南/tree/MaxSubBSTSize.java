package 程序员代码面试指南.tree;

import algorithmBase.tree.TreeNode;

/**
 * 求最大二叉搜索树的节点个数
 * 思路：
 * 递归获取最大二叉搜索树的可能情况
 * 1）与节点X有关（经过该节点），即左边+1+右边  【左边是二叉搜索树，右边是二叉搜索树，合起来也是二叉搜索树】
 * 2）与节点X无关（不经过该节点），即max(左子树的最大二叉搜索树节点个数，左子树的最大二叉搜索树节点个数)
 * <p>
 * 二叉树的递归套路：
 * 1、假设以X节点为头结点，假设可以向X的左右子树获取任何信息
 * 2、基于1的假设，讨论以X为头节点的树，得到答案的可能性     ❗️(最重要)
 *      1）X节点参与
 *      2）X节点不参与
 * 3、列出所有可能后，确定到底需要向左右子树获取什么信息
 * 4、把左右子树信息求全集，就死任何一棵子树都需要返回的信息Info
 * 5、递归函数都行需要返回Info，每一棵子树都这么要求
 * 6、编写代码，在代码中考虑如何把左子树和右子树的信息整合出整棵树的信息Info
 */
public class MaxSubBSTSize {
    public static int maxSubBSTSize(TreeNode root) {
        if (root == null) return 0;
        return process(root).maxSubBSTSize;
    }

    private static Info process(TreeNode root) {
        // 因为root==null时，min和max不好直接给出，故返回null，后续自己进行判空处理
        if (root == null) return null;

        // 1、收集左右子树的信息
        Info left = process(root.left);
        Info right = process(root.right);

        // 2、整理并返回信息
        int min = root.value;
        int max = root.value;
        if (root.left != null) {
            min = Math.min(left.min, min);
            max = Math.max(left.max, max);
        }
        if (root.right != null) {
            min = Math.min(right.min, min);
            max = Math.max(right.max, max);
        }

        int maxSubBSTSize = 0;
        if (root.left != null) {
            maxSubBSTSize = left.maxSubBSTSize;
        }
        if (root.right != null) {
            maxSubBSTSize = Math.max(right.maxSubBSTSize, maxSubBSTSize);
        }

        // 为true的条件：左边为true && 右边为true && 该节点>左边最大值 &&  该节点<左边最小值
        boolean isAllBST = false;
        if ((left == null ? true : left.isAllBST)
                && (right == null ? true : right.isAllBST)
                && (left == null ? true : left.max < root.value)
                && (right == null ? true : right.min > root.value)) {
            maxSubBSTSize = (left == null ? 0 : left.maxSubBSTSize) + (right == null ? 0 : right.maxSubBSTSize) + 1;
            isAllBST = true;
        }


        return new Info(isAllBST, maxSubBSTSize, min, max);
    }


    // 对于任何子树都返回如下信息
    public static class Info {
        boolean isAllBST;   // 自身是否整体为搜索二叉树
        int maxSubBSTSize;  // 最大搜索二叉树的节点个数
        int min;            // 子树中的最小值
        int max;            // 子树中的最大值

        public Info(boolean isAllBST, int maxSubBSTSize, int min, int max) {
            this.isAllBST = isAllBST;
            this.maxSubBSTSize = maxSubBSTSize;
            this.min = min;
            this.max = max;
        }
    }

}
