package leetcode.code;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合
 * 思路：回溯算法
 * 组合问题和子集问题的本质是相同的，选择几个数的组合即在决策树的第几层进行收集
 */
public class lc_77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k > n || n < 1) return res;

        dfs(n, k, 1, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int n, int k, int index, ArrayList<Integer> chain, List<List<Integer>> res) {
        // 在决策树第 k 层进行结果收集,即截止条件
        if (chain.size() == k) {
            res.add(new ArrayList<>(chain));
            return;
        }
        // 候选节点，并进行剪枝操作,即剩下的数字不够组成k个数字的子树进行剪枝
        // n-i+1+chain.size() < k 则进行剪枝
        for (int i = index; i <= (n + chain.size() - k + 1); i++) {
            chain.add(i);
            dfs(n, k, i + 1, chain, res);
            chain.remove(chain.size()-1);
        }
    }
}
