package 剑指offer;

/**
 * 翻转单词顺序
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 * 为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 * 思路：先分割为若干个单元部分，然后借助StringBuilder进行反向 append 即可
 */
public class jz_58_I {
    public String reverseWords(String s) {
        String[] strs = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = strs.length - 1; i >= 0; i--) {
            // note "I" 被按照" "进行会得到两个字符串，"I " 和 ""  todo
            // note 该问题其他小伙伴遇到过，自己特意试了Java、Go、Python都是上述的分割方式！
            if (strs[i].equals(""))
                continue;

            if (i == 0) sb.append(strs[i]);
            else sb.append(strs[i]).append(" ");
        }
        return sb.toString();
    }
}
