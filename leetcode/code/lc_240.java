package leetcode.code;

/**
 * 搜索二维矩阵II
 * 从左到右升序，从上到下升序   (剑指offer矩阵搜索题)
 * 思路：利用数据本身特性，从矩阵的右上角开始，一次排除掉一行或一列
 */
public class lc_240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        int rows = matrix.length, cols = matrix[0].length;
        int i = 0, j = cols - 1;       // 从右上角的位置开始搜索
        while (i >= 0 && i < rows && j >= 0 && j < cols) {
            if (matrix[i][j] < target) i++;           // 排除掉一行
            else if (matrix[i][j] > target) j--;          // 排除掉一列
            else return true;
        }
        return false;
    }
}
