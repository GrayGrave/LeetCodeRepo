package leetcode.code;

import java.util.Arrays;

/**
 * 零钱兑换             返回凑齐总金额所需的最少硬币个数，每种硬币数量不限,无法凑齐则返回-1
 * 思路：dp（完全背包🎒问题）  dp[i]代表组成金额 i 所需的最少硬币数量 (数组滚动更新)
 * note: 二维dp数组-> dp[i][j]代表使用前i种硬币，组成金额j所需的最少硬币数量
 */
public class lc_322 {
    public int coinChange(int[] coins, int amount) {
        // 金额为0，所需最少的硬币数为0
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE / 2);  // 便于后续进行更新
        dp[0] = 0;
        // 数组滚动更新  二维dp数组-> dp[i][j]代表使用前i种硬币，组成金额j所需的最少硬币数量
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {  // 正序进行更新dp表
                // 考虑要不要此种硬币💡
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] == Integer.MAX_VALUE / 2 ? -1 : dp[amount];
    }
}
