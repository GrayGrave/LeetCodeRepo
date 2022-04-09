package leetcode.code;

/**
 * Z 字形变换
 *  numRows = 4
 *        A         G
 *        B  F      H  L
 *        C E       I K
 *        D         J
 *  输出：AGBFHCEIDJ
 *  思路：设置容器，将字符放入对应容器，最后再收集起来即可。确定字符对应容器，将变换的图形拆开成单个可重复的V进行分析💡
 */
public class lc_06 {
    public String convert(String s, int numRows) {
        if (numRows <= 1) return s;
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuilder("");
        }
        // 遍历s，每个字符放入对应的行（StringBuilder）
        for (int i = 0; i < s.length(); i++) {
            // 1、确定字符放入的容器
            int index = i % (2 * numRows - 2);
            index = index < numRows ? index : 2 * numRows - 2 - index;   // index >= numRows，V字右半边的情况处理
            // 2、字符放入容器
            sb[index].append(s.charAt(i));
        }
        // 3、进行容器字符收集
        for (int i = 1; i < sb.length; i++) {
            sb[0].append(sb[i]);
        }
        return sb[0].toString();
    }
}

