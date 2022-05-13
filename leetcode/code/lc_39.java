package leetcode.code;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合总和
 * 同一个数字可以无限制使用
 * 思路：回溯算法
 */
public class lc_39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return res;
        dfs(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int[] nums, int target, int index, ArrayList<Integer> chain, List<List<Integer>> res) {
        // 截止条件
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(chain));
            return;
        }

        // 候选节点
        for (int i = index; i < nums.length; i++) {
            chain.add(nums[i]);
            // 此处 i 没有进行+1，是因为数字可以无限制重复使用
            dfs(nums, target - nums[i], i, chain, res);
            chain.remove(chain.size() - 1);
        }

    }
}
