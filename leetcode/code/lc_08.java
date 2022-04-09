package leetcode.code;

/**
 * 字符串转换为整数(atoi)  注意细节！ todo
 */
public class lc_08 {
    public int stringToInteger(String str) {
        if (str == null || str.length() == 0) return 0;
        str = str.trim();
        if (str.equals("")) return 0;
        char firstChar = str.charAt(0);
        int sign = 1;
        int start = 0;
        long res = 0;
        if (firstChar == '+') {
            sign = 1;
            start++;
        } else if (firstChar == '-') {
            sign = -1;
            start++;
        }
        for (int i = start; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return (int) (sign * res);
            }
            res = res * 10 + str.charAt(i) - '0';
            if (sign == 1 && res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (sign == -1 && res > Integer.MAX_VALUE) return Integer.MIN_VALUE;
        }
        return (int) res * sign;
    }
}
