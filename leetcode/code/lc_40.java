package leetcode.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 组合总和II
 * 不包含重复的组合 -> 排序、跳过
 * 思路：回溯算法
 */
public class lc_40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return res;

        // 排序后相同数字靠在一起，解决重复组合的问题
        Arrays.sort(candidates);

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
            // 解决重复元素的问题，跳过之后不会出现重复的组合
            if (i > index && nums[i] == nums[i - 1]) continue;

            chain.add(nums[i]);
            dfs(nums, target - nums[i], i+1, chain, res);
            chain.remove(chain.size() - 1);
        }
    }
}
