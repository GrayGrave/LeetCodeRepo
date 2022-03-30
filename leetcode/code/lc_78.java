package leetcode.code;

import java.util.ArrayList;
import java.util.List;

/**
 * 子集
 * 思路：回溯算法
 */
public class lc_78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) return res;
        dfs(nums, 0, new ArrayList(), res);
        return res;
    }

    private void dfs(int[] nums, int index, ArrayList<Integer> chain, List<List<Integer>> res) {
        // 树的每一个节点都是一个子集结果，加入res
        res.add(new ArrayList<>(chain));

        // 候选节点,考虑每个数选或者不选
        for (int i = index; i < nums.length; i++) {
            chain.add(nums[i]);
            dfs(nums, i + 1, chain, res);
            chain.remove(chain.size() - 1);
        }
    }

}
