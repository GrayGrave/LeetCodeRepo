package leetcode.code;

/**
 * 零钱兑换II           返回凑齐总金额的方法总数，每种硬币数量不限
 * 思路：dp（完全背包🎒问题）   dp[i]代表组成金额 i 的方法总数 (数组滚动更新)
 *   note: 二维dp数组-> dp[i][j]代表使用前i种硬币，组成金额j的方法总数
 */
public class lc_518 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        // 组成金额0的方法总数为1，即使用每种硬币的个数为0，note：注意与零钱兑换I的区别
        dp[0] = 1;

        for (int coin : coins) {                        // 数组滚动更新
            for (int i = coin; i <= amount; i++) {      // 正序进行更新dp表
                dp[i] += dp[i - coin];                  // 即两种到达方案相加(上边和左边)
            }
        }
        return dp[amount];
    }
}
