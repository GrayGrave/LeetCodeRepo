package leetcode.code;

import java.util.Stack;

/**
 * 接雨水
 * 给定n个非负整数表示每个宽度为1的柱子的高度图，计算下雨后可以接多少雨水
 * 思路：单调栈/化整为零
 *
 * 单调栈解决问题的原型，即数组中的每个元素需要知道左边和右边离它最近的比它大的数是多少。
 * 1.解决上述问题最简单直观的做法，就是创建数组挨着去找左边和右边离它最近切比它大的数（方法二）
 * 2.优化一点，即可利用单调栈进行解决(方法一)
 *
 * 单调栈详解
 * 数组： 5，4，3，6，1，2，0，7
 * 寻找每个位置左右距离最近比它大的数，建立单调栈从栈底到栈顶依次递减
 * 当元素6准备放入单调栈时，发现比栈顶元素3大，即开始出栈3(即开始输出信息，对于元素3而言，左右距离最近比它大的元素即为4和6)，
 * 接着对比6和4，继续出栈，输出信息。
 * 再比较6和5，继续出栈，输出信息。
 * 最后6放入栈，接着处理数组中的1，重复上面的过程。
 */
public class lc_42 {
    /**=================================== 单调栈解法(推荐！) ========================================*/
    // 方法一：单调栈
    // 每个元素需要知道左边和右边离它最近的比它大的数是多少 => 采用单调递减栈(栈底到栈顶依次减小)
    // 确定左右边界，则横扫出一个矩阵块，所有的这种矩阵块之和便是接雨水的总量
    public int trap2(int[] height) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {// 出栈，生成目前栈顶元素的左右比它大距离最近的相关信息
                int curr = stack.pop();  // 产出该元素的信息
                if (stack.isEmpty()) {   // 左边没有更高的边界，无法横扫出"矩阵块"
                    break;
                }
                int left = stack.peek();  // 左边最近的比它大的元素
                int right = i;            // 右边最近的比它大的元素
                int h = Math.min(height[left], height[right]) - height[curr]; // 横扫出矩阵块的高，然后乘以矩阵块的底获得矩阵面积
                res += (right - left - 1) * h;
            }
            stack.push(i);
        }
        return res;
    }


    // 方法二: 关注height[i]处可以接多少水，与此处高度和左右最高的高度有关（关注头顶的雨水量）
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
}
