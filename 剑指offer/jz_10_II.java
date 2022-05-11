package 剑指offer;

/**
 * 青蛙跳台阶问题
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * 思路：dp  dp[i]代表跳上一个i级台阶共有的跳法
 */
public class jz_10_II {
    public int numWays(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;

        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[n];
    }
}

