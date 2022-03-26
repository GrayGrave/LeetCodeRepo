package leetcode.code;

/**
 * 原地旋转正方形图像
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
