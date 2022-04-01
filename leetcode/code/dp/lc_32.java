package leetcode.code.dp;

/**
 * 最长有效括号     【hard】
 * 找出最长有效的括号子串的长度 ('('、')')
 * 思路：dp     note：有点难理解，第一次接触时花了大力气搞懂(左-书)
 * dp[i]代表以s[i]结尾的最长有效括号长度
 */
public class lc_32 {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) return 0;
        char[] chs = s.toCharArray();
        int[] dp = new int[chs.length];
        int res = 0;
        int pre = 0;

        // 更新dp表
        for (int i = 1; i < chs.length; i++) {
            if (chs[i] == ')') {
                // 与该')' 匹配的'('所在的位置
                // note：为何不直接用dp[i]进行查找，因为此时dp[i]还没有获得结果
                pre = i - dp[i - 1] - 1;
                if (pre >= 0 && chs[pre] == '(') {     // 若不满足条件则无法以该位置字符作为结尾
                    // todo 核心状态转移方程  以i位置匹配到的+以前一个位置匹配到的
                    dp[i] = dp[i - 1] + 2 + (pre > 0 ? dp[pre - 1] : 0);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
