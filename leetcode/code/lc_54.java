package leetcode.code;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵       顺时针螺旋打印矩阵，绪君字节面试题
 * 思路: 依次尝试往右、下、左、上走直线，碰到边界或者已经访问过的位置，则尝试下一个方向
 */
public class lc_54 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[0];

        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
        int[] res = new int[(r + 1) * (b + 1)];
        while (true) {
            for (int i = l; i <= r; i++) res[x++] = matrix[t][i]; //left->right  活动空间减去顶层
            if (++t > b) break;

            for (int i = t; i <= b; i++) res[x++] = matrix[i][r]; //top->bottom  活动空间减去右边一竖
            if (--r < l) break;

            for (int i = r; i >= l; i--) res[x++] = matrix[b][i]; //right->left   活动空间减去底层
            if (--b < t) break;

            for (int i = b; i >= t; i--) res[x++] = matrix[i][l]; //bottom->top   活动空间减去左边一竖
            if (++l > r) break;
        }
        return res;
    }


    public List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int rows = matrix.length, columns = matrix[0].length;
        boolean[][] visited = new boolean[rows][columns];

        int total = rows * columns;
        int row = 0, column = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};  // 依次尝试的四个方向
        int directionIndex = 0;

        for (int i = 0; i < total; i++) {
            res.add(matrix[row][column]);
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
