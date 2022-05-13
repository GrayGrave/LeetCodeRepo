package leetcode.code;

/**
 * 编辑距离  【经典 dp问题】
 * word1 转换到 word2 经过的最少编辑次数，可以进行三种操作：插入字符、删除字符、替换字符
 * 思路：dp dp[i][j] 代表word1[0..i]转换为word2[0..j]需要的最少编辑次数
 *  ---> j
 * |i
 */
public class lc_72 {
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        // 第一行，第一列需要引入""单独考虑
        int[][] dp = new int[n1 + 1][n2 + 1];

        // 处理边界情况
        // 第一行
        for (int i = 1; i <= n2; i++) {
            dp[0][i] = dp[0][i - 1] + 1;     // 插入操作
        }
        // 第一列
        for (int i = 1; i <= n1; i++) {
            dp[i][0] = dp[i - 1][0] + 1;     // 插入操作
        }

        // 填写dp表
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                // 核心状态转移方程
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                /**
                 * dp[i - 1][j - 1] 表示先保证word1[0..i-1]转换到word2[0..j-1]，然后再进行一次替换操作
                 * dp[i-1][j] 表示先保证word1[0..i-1]转换到word2[0..j]，然后再进行一次删除操作
                 * dp[i][j - 1] 表示先保证word1[0..i]转换到word2[0..j-1]，然后再进行一次插入操作
                 */
                else dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;

            }
        }
        return dp[n1][n2];
    }
}
