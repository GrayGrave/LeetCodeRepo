package 剑指offer;

import java.util.*;

/**
 * 和为s的连续正数序列  todo
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * 思路：滑动窗口
 */
public class jz_57_II {
    /**
     * 方法一：滑动窗口
     * 脑海里要有一个区间的概念，这里的区间是(1, 2, 3, ..., target - 1)
     * 套滑动窗口模板，l是窗口左边界，r是窗口右边界，窗口中的值一定是连续值。
     * 当窗口中数字和小于target时，r右移; 大于target时，l右移; 等于target时就获得了一个解
     */
    public int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();

        for (int l = 1, r = 1, sum = 0; r < target; r++) {
            sum += r;
            while (sum > target) {
                sum -= l++;
            }
            if (sum == target) {
                int[] temp = new int[r - l + 1];
                for (int i = 0; i < temp.length; i++) {
                    temp[i] = l + i;
                }
                list.add(temp);
            }
        }

        int[][] res = new int[list.size()][];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    // 方法二
    public int[][] findContinuousSequence2(int target) {
        if (target < 3) return new int[0][0];

        int left = 1, right = 1;
        int sum = 0;
        int end = target / 2;
        List<int[]> res = new ArrayList<>();
        while (left <= end) {
            if (sum < target) {
                sum += right;
                right++;
            } else if (sum > target) {
                sum -= left;
                left++;
            } else {
                int[] arr = new int[right - left];
                for (int i = left; i < right; i++) {
                    arr[i - left] = i;
                }
                res.add(arr);
                sum -= left;
                left++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
