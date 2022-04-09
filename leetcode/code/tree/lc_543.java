package leetcode.code.tree;

import leetcode.dataStruct.TreeNode;


/**
 * 二叉树的直径   即树的最大距离
 * 思路：典型二叉树递归套路
 */
public class lc_543 {
    /** 解法一：树的最大距离是某节点的左右子树深度和最大，故后序时关注左右子树返回的树深度即可 */
    // 记录最大直径的长度
    int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return maxDiameter;
    }

    int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);

        // 后序位置，顺便计算最大直径
        int myDiameter = leftMax + rightMax;
        maxDiameter = Math.max(maxDiameter, myDiameter);

        return 1 + Math.max(leftMax, rightMax);
    }

    /**=============================== 分割线 ====================================*/

    // 解法二:
    public int diameterOfBinaryTree2(TreeNode root) {
        // 两点之间的路径长度是以他们之间的边数目表示，路径经过节点减1即可
        return process(root).maxDistance - 1;
    }

    private static Info process(TreeNode root) {
        if (root == null) return new Info(0, 0);
        // 1、获取左右子树信息
        Info left = process(root.left);
        Info right = process(root.right);

        // 2、整理并返回信息
        int height = Math.max(left.height, right.height) + 1;
        int maxDistance = Math.max(Math.max(left.maxDistance, right.maxDistance), left.height + right.height + 1);
        return new Info(maxDistance, height);
    }


    public static class Info {
        public int maxDistance;
        public int height;

        public Info(int maxDistance, int height) {
            this.maxDistance = maxDistance;
            this.height = height;
        }
    }

}
