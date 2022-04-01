package leetcode.code.dfs.backTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 子集II
 * 数组中包含重复元素，要求返回不重复的子集    -> 排序、跳过
 * 思路：回溯算法
 */
public class lc_90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) return res;
        // 先将数组进行排序，重复的元素会靠在一起
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int[] nums, int index, ArrayList<Integer> chain, List<List<Integer>> res) {
        res.add(new ArrayList<>(chain));    // res.add(chain)

        // 候选节点
        for (int i = index; i < nums.length; i++) {
            // 解决重复元素的问题，跳过之后不会出现重复的子集
            if (i > index && nums[i] == nums[i - 1]) continue;

            chain.add(nums[i]);
            dfs(nums, i + 1, chain, res);
            chain.remove(chain.size() - 1);
        }
    }
}
