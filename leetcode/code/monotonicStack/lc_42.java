package leetcode.code.monotonicStack;

import java.util.Stack;

/**
 * 接雨水
 * 给定n个非负整数表示每个宽度为1的柱子的高度图，计算下雨后可以接多少雨水
 * 思路：单调栈/化整为零
 */
public class lc_42 {

    // 方法一: 关注height[i]处可以接多少水，与此处高度和左右最高的高度有关（关注头顶的雨水量）
    public int trap(int[] height) {
        if (height.length < 3) return 0;
        int n = height.length;
        int res = 0;

        int[] lmax = new int[n];     // i处(包括i)左边的最大高度
        int[] rmax = new int[n];     // i处(包括i)右边的最大高度
        lmax[0] = height[0];
        rmax[n - 1] = height[n - 1];

        // 计算每一点左右的最高高度
        for (int i = 1; i < n; i++) lmax[i] = Math.max(height[i], lmax[i - 1]);
        for (int i = n - 2; i >= 0; i--) rmax[i] = Math.max(height[i], rmax[i + 1]);
        // 计算答案
        for (int i = 1; i < n - 1; i++) {    //边界上面不会右雨水
            // 若i处为全局最高处，则该处盛水量为0
            int h = Math.min(lmax[i], rmax[i]) - height[i];
            int water = h > 0 ? h : 0;   // 可优化为Math.max(h,0)
            res += water;
        }
        return res;
    }

    /**=================================== 单调栈解法 ========================================*/
    // 方法二：单调栈
    // 采用单调递减栈
    public int trap2(int[] height) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int curr = stack.peek();
                stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                int right = i;
                int h = Math.min(height[left], height[right]) - height[curr];
                res += (right - left - 1) * h;
            }
            stack.push(i);
        }
        return res;
    }
}
