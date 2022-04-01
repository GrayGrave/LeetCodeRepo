package leetcode.code.dp;

/**
 * 打家劫舍    不能抢劫挨着的房屋，计算可以抢劫的最大财产值
 * 思路：dp  dp[i]代表抢到nums[i]位置所能获取的最大价值
 */
public class lc_198 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n <= 1) return n == 0 ? 0 : nums[0];

        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            // note 对位置i进行分析，可能是抢劫i-2来到此处，或者是抢劫i-1处来到此处(即从两个状态可以转移到此种状态)
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + dp[i]);
        }
        return dp[n - 1];
    }

}
