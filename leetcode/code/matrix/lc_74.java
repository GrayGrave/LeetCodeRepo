package leetcode.code.matrix;

/**
 * 搜索二维矩阵
 * 1   2   3   4
 * 6   8   9  10
 * 23 29  89  99
 * 思路：
 * 解法一：拉通进行二分查找
 * 解法二:两次二分，第一次确定目标值所在的行，第二次确定所在行中的位置
 */
public class lc_74 {
    // 解法一
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int rows = matrix.length, cols = matrix[0].length;

        // 二分查找
        int l = 0, r = rows * cols - 1;
        int pivotIdx, pivotElement;
        while (l <= r) {             // l与r相等时任然需要进行比较
            pivotIdx = (l + r) / 2;
            pivotElement = matrix[pivotIdx / cols][pivotIdx % rows];
            if (target == pivotElement) return true;
            else if (target > pivotElement) l = pivotIdx + 1;
            else r = pivotIdx - 1;
        }
        return false;
    }

}
