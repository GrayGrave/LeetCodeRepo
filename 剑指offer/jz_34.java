package 剑指offer;

import leetcode.code.dataStruct.TreeNode;

import java.util.*;

/**
 * 二叉树中和为某一值的路径
 * 思路：回溯
 */
public class jz_34 {
    private List<List<Integer>> res;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        res = new ArrayList<>();
        dfs(root, sum, new ArrayList<>());
        return res;
    }

    private void dfs(TreeNode node, int target, List<Integer> chain) {
        if (node == null) return;

        chain.add(node.val);                    // 压入
        target -= node.val;
        if (target == 0 && node.left == null && node.right == null) {
            res.add(new ArrayList<>(chain));
        } else {
            dfs(node.left, target, chain);
            dfs(node.right, target, chain);
        }
        chain.remove(chain.size() - 1); // 弹出
    }
}
