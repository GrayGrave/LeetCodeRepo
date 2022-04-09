package leetcode.code;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 翻转字符串里的单词        note：细节题
 * 输入：s = "the sky is blue"
 * 输出："blue is sky the"
 * 思路：每个单词分别翻转，然后整体翻转，或者先整体翻转，再每个单词分别翻转。（注意，要处理空格！）
 */
public class lc_151 {
    // 方法一：处理空格-整体翻转-每个单词翻转
    public String reverseWords(String s) {
        // 处理空格
        StringBuilder sb = trimSpaces(s);
        // 翻转字符串
        reverse(sb, 0, sb.length() - 1);
        // 翻转每个单词
        reverseEachWord(sb);
        return sb.toString();
    }

    // 处理空格
    public StringBuilder trimSpaces(String s) {
        int left = 0, right = s.length() - 1;
        // 去掉字符串开头的空白字符
        while (left <= right && s.charAt(left) == ' ') {
            ++left;
        }

        // 去掉字符串末尾的空白字符
        while (left <= right && s.charAt(right) == ' ') {
            --right;
        }

        // 将字符串间多余的空白字符去除
        StringBuilder sb = new StringBuilder();
        while (left <= right) {
            char c = s.charAt(left);

            if (c != ' ') {
                sb.append(c);
            } else if (sb.charAt(sb.length() - 1) != ' ') {
                sb.append(c);
            }

            ++left;
        }
        return sb;
    }

    public void reverse(StringBuilder sb, int left, int right) {
        while (left < right) {
            char tmp = sb.charAt(left);
            sb.setCharAt(left++, sb.charAt(right));
            sb.setCharAt(right--, tmp);
        }
    }

    public void reverseEachWord(StringBuilder sb) {
        int n = sb.length();
        int start = 0, end = 0;

        while (start < n) {
            // 循环至单词的末尾
            while (end < n && sb.charAt(end) != ' ') {
                ++end;
            }
            // 翻转单词
            reverse(sb, start, end - 1);
            // 更新start，去找下一个单词
            start = end + 1;
            ++end;
        }
    }


    // 方法二：利用语言工具
    public String reverseWords2(String s) {
        // 除去开头和末尾的空白字符
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔符分割
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }

}
