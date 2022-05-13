package leetcode.code;

import java.util.Stack;

/**
 * 柱状图中最大的矩形
 * 思路：单调栈
 * 单调栈解决问题的原型，即数组中的每个元素需要知道左边和右边离它最近的比它大的数是多少。
 * 此题数组中的每个元素需要知道左边和右边离它最近比它小的数是多少，然后左右扫出最大的矩形。
 */
public class lc_84 {
    // 单调栈经典问题
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();               // 单调栈存放的是递增数组值所在数组的下标
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            // 单调递增栈，即栈中原数对应的数据，由底到顶递增
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int index = stack.pop();
                int leftIndex = stack.isEmpty() ? -1 : stack.peek();  // 当左边没有更小的数时，取-1保证计算面积的兼容性
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
