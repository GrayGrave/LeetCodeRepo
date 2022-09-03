package pointAtOffer;

/**
 * 求1+2+...+n
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class jz_64 {
    /**
     * 终止条件使用了if，不合题意，故下面使用逻辑运算符的短路效应 note：Krahets的解法
     * public int sumNums(int n) {
     *      if (n == 1) return 1;
     *      n += sumNums(n - 1);
     *      return n;
     *  }
     */
    public int sumNums(int n) {
        // doubt 本题需要实现 “当 n = 1时终止递归” 的需求，可通过短路效应实现。
        boolean x = n > 1 && (n += sumNums(n - 1)) > 0;
        return n;
    }

}
