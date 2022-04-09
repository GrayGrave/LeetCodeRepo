package leetcode.code;

/**
 * 比较版本号
 * 思路：双指针
 */
public class lc_165 {
    /**
     * split(String regex)的参数是正则表达式，正则表达式中的“.”表示除“\n”外的所有字符，
     * 所以匹配实际的“.”就需要用“\.”进行标记来表示，但“\”符号的使用还需要配合转义符“\”，
     * 即“\\”表示为一个“\”。所以最后通过"\\."来进行“.”的匹配
     */
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        for (int i = 0; i < v1.length || i < v2.length; ++i) {
            int x = 0, y = 0;
            if (i < v1.length) {
                x = Integer.parseInt(v1[i]);
            }
            if (i < v2.length) {
                y = Integer.parseInt(v2[i]);
            }
            if (x > y) {
                return 1;
            }
            if (x < y) {
                return -1;
            }
        }
        return 0;
    }
}
