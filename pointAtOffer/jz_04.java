package pointAtOffer;

/**
 * 二维数组中的查找
 * 从左往右递增，从上往下递增
 * 思路：从右上角开始比较，一次排除一行或一列
 */
public class jz_04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        // 从右上角开始比较
        int row = 0;
        int col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] > target) col--;
            else if (matrix[row][col] < target) row++;
            else return true;
        }
        return false;
    }
}
