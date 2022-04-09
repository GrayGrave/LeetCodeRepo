package leetcode.code;

/**
 * 整数反转
 */
public class lc_07 {
    // 解法一：不使用long类型辅助，更优的解法
    public int reverse(int x) {
        int res = 0;
        int last = 0;
        while (x != 0) {
            //每次取末尾数字
            int tmp = x % 10;
            last = res;
            res = res * 10 + tmp;
            //判断整数溢出💡
            if (last != res / 10) {
                return 0;
            }
            x /= 10;
        }
        return res;
    }

    // 解法二：使用long类型辅助
    public int reverse2(int x) {
        int signal = 1;
        if (x < 0) signal = -1;

        x = Math.abs(x);
        long res = 0;
        for (; x != 0; x /= 10) {
            res = res * 10 + x % 10;
        }
        res *= signal;
        return res > Integer.MAX_VALUE || res < Integer.MIN_VALUE ? 0 : (int) res;    //检查是否越界
    }
}
