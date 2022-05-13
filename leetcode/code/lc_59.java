package leetcode.code;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵II
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix
 */
public class lc_59 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        if (n == 0) return res;

        int rows = n, columns = n;
        boolean[][] visited = new boolean[n][n];

        int total = rows * columns;
        int row = 0, column = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};  // 依次尝试的四个方向
        int directionIndex = 0;

        for (int i = 0; i < total; i++) {
            res[row][column] = i + 1;           // 进行数字填充
            visited[row][column] = true;        // 标记访问

            int nextRow = row + directions[directionIndex][0];
            int nextColumn = column + directions[directionIndex][1];
            // 转换前进方向的条件，越界或者遇到访问过的位置
            if (nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns || visited[nextRow][nextColumn]) {
                directionIndex = (directionIndex + 1) % 4;   // 按该方向前进不动时，更换下一个方向
            }
            // 确定下一步前进的位置
            row += directions[directionIndex][0];
            column += directions[directionIndex][1];
        }
        return res;
    }
}
