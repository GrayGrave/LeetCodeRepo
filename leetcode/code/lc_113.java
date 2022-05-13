package leetcode.code;

import leetcode.code.dataStruct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 路径总和II
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * 思路：回溯 note：(涉及到不同轨迹问题)  子集、组合、排列都属于回溯问题（需要记录轨迹->chain）此类问题都是从根节点出发，进行遍历，保存轨迹
 */
public class lc_113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        dfs(root, sum, new ArrayList<>(), res);
        return res;
    }

    private void dfs(TreeNode root, int sum, List<Integer> chain, List<List<Integer>> res) {
        //截止条件
        if (root == null) return;
        if (root.left == null && root.right == null) {
            // 找到一条符合条件的路径
            if (sum - root.val == 0) {
                chain.add(root.val);
                res.add(new ArrayList<>(chain));
                chain.remove(chain.size() - 1);
            }
            return;
        }

        // 候选节点--> 左右孩子
        chain.add(root.val);
        dfs(root.left, sum - root.val, chain, res);
        dfs(root.right, sum - root.val, chain, res);
        chain.remove(chain.size() - 1);

        /*chain.add(root.val);  note 此种写法可以合并，则形式便可常规回溯问题一样了(子集、组合、排列)
        dfs(root.left, sum - root.left.val, chain, res);
        chain.remove(chain.size() - 1);

        chain.add(root.val);
        dfs(root.right, sum - root.right.val, chain, res);
        chain.remove(chain.size() - 1);*/

    }
}
