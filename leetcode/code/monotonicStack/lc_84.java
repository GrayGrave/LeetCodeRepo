package leetcode.code.monotonicStack;

import java.util.Stack;

/**
 * 柱状图中最大的矩形
 * 思路：单调栈
 */
public class lc_84 {
    // 单调栈经典问题
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();               // 单调栈存放的是递增数组值的下标
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            // 单调递增栈，即栈中原数对应的数据，由底到顶递增
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int index = stack.pop();
                int leftIndex = stack.isEmpty() ? -1 : stack.peek();  // todo
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
