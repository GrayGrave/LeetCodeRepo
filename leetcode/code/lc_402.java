package leetcode.code;

/**
 * 移掉 k 位数字       note:lc_31 对比理解    todo
 * 给你一个以字符串表示的非负整数 num 和一个整数 k ，移除这个数中的 k 位数字，使得剩下的数字最小。请你以字符串形式返回这个最小的数字。
 * 输入：num = "10200", k = 1
 * 输出："200"
 * 解释：移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 *
 * 思路：从左到右，找第一个比后面大的字符，删除，清零，k次扫描。
 */
public class lc_402 {
    public String removeKdigits(String num, int k) {
        if (num.length() == k) return "0";
        StringBuilder s = new StringBuilder(num);

        for (int i = 0; i < k; i++) {
            int idx = 0;
            for (int j = 1; j < s.length() && s.charAt(j) >= s.charAt(j - 1); j++) idx = j;
            s.delete(idx, idx + 1);
            while (s.length() > 1 && s.charAt(0) == '0') s.delete(0, 1);
        }
        return s.toString();
    }
}
