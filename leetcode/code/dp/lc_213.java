package leetcode.code.dp;

/**
 * 打家劫舍II  房屋围成圈
 * 思路：dp
 * 首先首尾房间不能同时被抢，有三种不同的情况：都不被抢，第一间被抢，最后一间被抢 （第一种选择空间小，故最优决策结果出现在后两者中）
 */
public class lc_213 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n < 2) return n == 0 ? 0 : nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);

        // 第一间不抢
        int a = process(nums, 1, n);
        // 最后一间不抢
        int b = process(nums, 0, n - 1);
        return Math.max(a, b);
    }

    private int process(int[] nums, int i, int j) {
        int[] dp = new int[nums.length];
        dp[i] = nums[i];
        dp[i + 1] = Math.max(nums[i], nums[i + 1]);

        for (int k = i + 2; k < j; k++) {
            dp[k] = Math.max(dp[k - 1], dp[k - 2] + nums[k]);
        }
        return dp[j - 1];
    }
}
