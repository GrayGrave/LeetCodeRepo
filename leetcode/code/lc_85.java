package leetcode.code;

import java.util.Stack;

/**
 * 最大矩形             lc_84柱状图中的最大矩阵升级版       lc_221最大正方形利用动态规划解决
 * 给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 * 思路：单调栈
 */
public class lc_85 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int maxArea = 0;
        int[] heights = new int[matrix[0].length];
        // 逐行扫描，每次添加一行，构建heights 转化为柱状图中最大矩阵的问题
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                heights[j] = matrix[i][j] == '1' ? heights[j] + 1 : 0;    // 遇到0则此柱状高度变为0；
            }
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        return maxArea;
    }

    public int largestRectangleArea(int[] heights) {             // lc_84问题解法
        if (heights == null || heights.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();                    // 单调栈存放的是递增数组值的下标
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            // 单调递增栈，即栈中原数对应的数据，由底到顶递增
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int index = stack.pop();
                int leftIndex = stack.isEmpty() ? -1 : stack.peek();
                int curArea = (i - leftIndex - 1) * heights[index];
                maxArea = Math.max(maxArea, curArea);
            }
            stack.push(i);
        }

        // 处理栈中的数据
        while (!stack.isEmpty()) {
            int index = stack.pop();
            int leftIndex = stack.isEmpty() ? -1 : stack.peek();
            int curArea = (heights.length - leftIndex - 1) * heights[index];
            maxArea = Math.max(maxArea, curArea);
        }
        return maxArea;
    }
}
