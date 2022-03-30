package leetcode.code;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合总和III
 * k个数之和为n，数字为1-9，每个数字最多使用一次    不包含相同的组合
 * 思路：回溯算法
 */
public class lc_216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (k > n) return res;
        dfs(k, n, 1, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int k, int target, int index, ArrayList<Integer> chain, List<List<Integer>> res) {
        // 截止条件
        if (k == 0 && target == 0) {
            res.add(new ArrayList<>(chain));
            return;
        }
        if (k == 0 || target < 0) return;


        // 候选节点
        for (int i = index; i <= 9; i++) {
            chain.add(i);
            dfs(k - 1, target - i, i + 1, chain, res);
            chain.remove(chain.size() - 1);
        }

    }
}
