package 剑指offer;

/**
 * 斐波那契数列
 */
public class jz_10_I {
    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int pre1 = 0;
        int pre2 = 1;
        int cur = 0;
        for (int i = 2; i <= n; i++) {
            cur = (pre1 + pre2) % 1000000007;  // 题目要求进行取模
            pre1 = pre2;
            pre2 = cur;
        }
        return cur;
    }
}
