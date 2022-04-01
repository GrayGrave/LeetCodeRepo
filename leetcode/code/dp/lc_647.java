package leetcode.code.dp;

/**
 * 回文子串     给定一个字符串，统计其中回文子串的数量
 * note：与lc_05 最长回文子串，同一个问题载体
 * 思路：dp    dp[i][j]代表子串s[i..j]是否是回文子串   j>i => 填充右上角部分
 */
public class lc_647 {
    public int countSubstrings(String s) {
        if (s == null || s.equals("")) return 0;

        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        //单个字符都是回文子串
        for (int i = 0; i < n; i++) dp[i][i] = true;
        int res = s.length();

        // 填充dp表   j>i => 填充右上角部分，从左往右，从下往上  note：与lc_05 最长回文子串填充dp表一样
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i == 1) dp[i][j] = true;
                        // 中间为回文，两端字符相同则整体为回文子串
                    else dp[i][j] = dp[i + 1][j - 1];
                } else {
                    // 两端都不相同，则必不为回文子串
                    dp[i][j] = false;
                }
                // 出现回文子串，数量加1，即(i,j)是一种回文截取情况，两层for循环枚举所有情况，符合要求则进行加1
                if (dp[i][j]) res++;
            }
        }
        return res;
    }

}
