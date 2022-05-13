package leetcode.code;

import java.util.Arrays;

/**
 * 最长递增子序列   寻找最长严格递增子序列的长度
 * 思路：dp  dp[i]代表以nums[i]结尾的最长递增子序列长度
 */
public class lc_300 {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int res = 0;
        int len = nums.length;
        int[] dp = new int[len];

        // 子序列至少包含自己
        Arrays.fill(dp, 1);

        // dp表填充
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);  // 前面的最长递增子序列加上自身元素
            }
        }
        for (int i = 0; i < len; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
