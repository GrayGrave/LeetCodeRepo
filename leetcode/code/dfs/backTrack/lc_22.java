package leetcode.code.dfs.backTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成    根据所给的括号对数，生成所有可能的有效括号组合
 * 思路：回溯算法
 */
public class lc_22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) return res;

        char[] p = new char[]{'(', ')'};    // dfs 可供选择的决策
        int[] pb = new int[]{n, n};         // 左右括号还剩的数量

        dfs(n, p, pb, new StringBuilder(), res);
        return res;
    }

    private void dfs(int n, char[] p, int[] pb, StringBuilder chain, List<String> res) {
        // 截止条件
        if (chain.length() == 2 * n)
            res.add(chain.toString());

        // 候选节点，即选择左括号还是右括号
        // 选左括号
        if (pb[0] > 0) {
            pb[0]--;
            chain.append(p[0]);
            dfs(n, p, pb, chain, res);
            chain.deleteCharAt(chain.length() - 1);
            pb[0]++;
        }
        // 选右括号
        if (pb[1] > pb[0]) {    // 若右括号使用比左括号多，则明显不合题意，进行剪枝
            pb[1]--;
            chain.append(p[1]);
            dfs(n, p, pb, chain, res);
            chain.deleteCharAt(chain.length() - 1);
            pb[1]++;
        }
    }
}
