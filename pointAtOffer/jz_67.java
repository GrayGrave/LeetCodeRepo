package pointAtOffer;

/**
 * 把字符串转换为整数
 * 写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用 atoi 或者其他类似的库函数。
 * 说明：
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。
 * 如果数值超过这个范围，请返回 INT_MAX (2^31− 1) 或INT_MIN (−2^31)
 * 即，-2,147,483,648 到2,147,483,647
 *
 */
public class jz_67 {
    public int strToInt(String str) {
        char[] c = str.trim().toCharArray();   // 丢弃字符串开头的空格
        if (c.length == 0) return 0;

        int res = 0;       // 返回转换后的整数
        int bndry = Integer.MAX_VALUE / 10;  // 越界判断

        int i = 1, sign = 1;
        if (c[0] == '-') sign = -1;
        else if (c[0] != '+') i = 0; // 第一位是数字，则从第一位开始进行转换

        for (int j = i; j < c.length; j++) {
            if (c[j] < '0' || c[j] > '9') break;    // note 遇到非数字字符，转换终止
            if (res > bndry || res == bndry && c[j] > '7') // note  Integer.MAX_VALUE 最后一位是7
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;  // 越界处理
            res = res * 10 + (c[j] - '0');
        }
        return sign * res;
    }
}
