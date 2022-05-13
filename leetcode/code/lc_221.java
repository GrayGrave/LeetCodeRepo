package leetcode.code;

/**
 * 最大正方形
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 * 思路：dp   dp[i][j]表示以matrix[i][j]为右下角的最大正方形边长，考虑该点的上、左上、左三个点的情况进行状态更新
 * */
public class lc_221 {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;

        int[][] dp = new int[matrix.length][matrix[0].length];
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') dp[i][j] = 0;
                else {
                    dp[i][j] = 1;
                    if (i >= 1 && j >= 1) {
                        dp[i][j] += Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));  // note： 状态转移方程
                    }
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res * res;
    }
}
