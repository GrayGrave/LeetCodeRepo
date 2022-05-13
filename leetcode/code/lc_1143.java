package leetcode.code;

/**
 * 最长公共子序列     【经典二维动态规划问题，同编辑距离】
 * 思路：dp
 * note 在最长递增子序列中，dp[i] 表示以 Si 为结尾的最长递增子序列长度，子序列必须包含 Si
 * note 在最长公共子序列中，dp[i][j] 表示 S1 中前 i 个字符与 S2 中前 j 个字符的最长公共子序列长度，不一定包含 S1i 和 S2j。
 */
public class lc_1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length(), n2 = text2.length();
        // note 与lc_72编辑距离类似，第一行，第一列需要引入""单独考虑
        int[][] dp = new int[n1 + 1][n2 + 1];

        // dp表填充 (第一行和第一列都为0，不用再进行填充)
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                // 相同则直接作为公共子序列的最后一个字符，长度加1
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // 不相同则在减1规模中找较大者
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n1][n2];
    }
}
