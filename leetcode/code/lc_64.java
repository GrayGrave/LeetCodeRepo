package leetcode.code;

/**
 * 最小路径和   到达右下角的最小路径和
 * 思路：dp    dp[i][j]代表到达(i,j)的最小路径和，可以进行滚动更新，将二维dp表降为1维
 * (i,j)转移来源（i，j-1）和（i-1,j）
 */
public class lc_64 {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int[] dp = grid[0];
        // 先填充第一行，base case (第一行到达（0，j）只能从左边(0,j-1)转换而来 )
        for (int i = 1; i < grid[0].length; i++) {
            dp[i] += dp[i - 1];
        }
        // 数组滚动更新
        for (int i = 1; i < grid.length; i++) {
            dp[0] += grid[i][0];
            for (int j = 1; j < grid[0].length; j++) {
                dp[j] = Math.min(dp[j - 1], dp[j]) + grid[i][j];
            }
        }
        return dp[grid[0].length - 1];
    }
}
