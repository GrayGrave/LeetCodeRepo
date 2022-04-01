package leetcode.code.twoPointer;

import java.util.HashMap;
import java.util.Map;

/**
 * 最小覆盖子串   note： 【hard】经典滑动窗口问题  todo
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中[涵盖](即包含) t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 ""
 * 例如: s="ADOBECODEBANC" ,t="ABC",输出BANC
 * 思路：双指针 -> 滑动窗口
 */
public class lc_76 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();   // 记录t的字符统计情况
        Map<Character, Integer> window = new HashMap<>(); // 记录窗口中的字符统计情况

        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1); // 初始化need
        }
        int l = 0, r = 0;       // 滑动窗口边界
        int valid = 0;        // 表示窗口中满足need条件的字符个数
        int start = 0, len = Integer.MAX_VALUE; // 记录最小覆盖子串的起始位置以及长度

        while (r < s.length()) {
            char cur = s.charAt(r);
            r++; // 右边界前进，即扩张
            // 进行窗口内数据的更新
            if (need.containsKey(cur)) {
                window.put(cur, window.getOrDefault(cur, 0) + 1);
                if (window.get(cur).compareTo(need.get(cur)) == 0)    // 字符数量达到相同数目
                    valid++;
            }

            while (valid == need.size()) {     // 判断左窗口是否要进行收缩
                // 更新最小覆盖子串长度
                if (r - l < len) {               // [l,r)
                    start = l;
                    len = r - l;
                }
                char d = s.charAt(l);
                l++; // 左边界前进，即收缩
                // 进行窗口内数据更新
                if (need.containsKey(d)) {
                    if (window.get(d).compareTo(need.get(d)) == 0) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);   // len未更新则说明没有覆盖子串出现

    }
}
