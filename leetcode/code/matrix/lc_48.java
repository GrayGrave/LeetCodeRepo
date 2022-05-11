package leetcode.code.matrix;

/**
 * 原地旋转正方形图像（顺时针）
 * 思路：
 *  方法一：数学角度，第一步转置矩阵、第二步分别翻转每一行
 *  方法二：宏观调度思路，每一圈进行旋转操作，化整为零
 */
public class lc_48 {
    public void rotate(int[][] matrix) {
        int N = matrix.length;
        // 第一步：转置矩阵
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        // 第二步：翻转每一行
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= (N - 1) / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][N - 1 - j];
                matrix[i][N - 1 - j] = tmp;
            }
        }
    }
}
