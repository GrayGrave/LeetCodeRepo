package pointAtOffer;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * 剪绳子II
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m - 1] 。请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 注：答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * 思路：dp  dp[i]代表把长度为 i 的绳子剪成若干段之后各段长度乘积的最大值
 *          利用BigInteger解决取模的问题
 */
public class jz_14_II {
    public int cuttingRope(int n) {
        BigInteger dp[] = new BigInteger[n + 1];
        Arrays.fill(dp, BigInteger.valueOf(1));
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = dp[i].max(BigInteger.valueOf(j * (i - j))).max(dp[i - j].multiply(BigInteger.valueOf(j)));
            }
        }
        return dp[n].mod(BigInteger.valueOf(1000000007)).intValue();
    }
}

