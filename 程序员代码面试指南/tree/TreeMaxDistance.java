package 程序员代码面试指南.tree;

import algorithmBase.tree.TreeNode;

/**
 * 求树的最大距离，即节点之间经过的最大步数+1   A-B-C 距离为3
 * 思路：
 * 递归获取最大距离的可能情况
 * 1）最大距离不经过此节点，即最大距离为左右子树最大距离的较大者
 * 2）最大距离经过此节点，即最大距离为左子树高度+1+右子树高度
 */
public class TreeMaxDistance {
    public static int TreeMaxDistance(TreeNode root) {
        return process(root).maxDistance;
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
