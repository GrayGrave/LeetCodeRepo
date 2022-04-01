package leetcode.code.dfs.backTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列
 * 不含重复数字的数组，返回所有可能的排列
 * 思路：回溯算法
 */
public class lc_46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // 组合问题不要记录是否访问过，排列问题需要进行记录，因为组合问题index指针是直接往后扫的，不会往前扫
        int[] visited = new int[nums.length];
        dfs(nums, visited, new ArrayList<Integer>(), res);
        return res;
    }

    private void dfs(int[] nums, int[] visited, ArrayList<Integer> chain, List<List<Integer>> res) {
        // 截止条件
        if (chain.size() == nums.length) {
            res.add(new ArrayList<>(chain));
            return;
        }
        // 候选节点
        for (int i = 0; i < nums.length; i++) {
            // 筛选,已经访问过直接跳过
            if (visited[i] == 1) continue;

            // 标记访问
            visited[i] = 1;
            chain.add(nums[i]);
            dfs(nums, visited, chain, res);
            chain.remove(chain.size() - 1);
            // 恢复现场，回溯思想
            visited[i] = 0;
        }
    }
}
