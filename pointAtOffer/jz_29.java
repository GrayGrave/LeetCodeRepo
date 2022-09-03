package pointAtOffer;

/**
 * 顺时针打印矩阵
 */
public class jz_29 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[0];

        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
        int[] res = new int[(r + 1) * (b + 1)];
        while (true) {
            for (int i = l; i <= r; i++) res[x++] = matrix[t][i]; //left->right  活动空间减去顶层
            if (++t > b) break;
            for (int i = t; i <= b; i++) res[x++] = matrix[i][r]; //top->bottom  活动空间减去右边一竖
            if (--r < l) break;
            for (int i = r; i >= l; i--) res[x++] = matrix[b][i];//right->left   活动空间减去底层
            if (--b < t) break;
            for (int i = b; i >= t; i--) res[x++] = matrix[i][l];//bottom->top   活动空间减去左边一竖
            if (++l > r) break;
        }
        return res;
    }

    /**=================================== 分割线 =========================================*/
    public int[] spiralOrder2(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int rows = matrix.length, columns = matrix[0].length;
        boolean[][] visited = new boolean[rows][columns];
        int[] res = new int[rows * columns];
        int index = 0;

        int total = rows * columns;
        int row = 0, column = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};  // 依次尝试的四个方向
        int directionIndex = 0;

        for (int i = 0; i < total; i++) {
            res[index++] = (matrix[row][column]);
            visited[row][column] = true;            // 标记访问

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
