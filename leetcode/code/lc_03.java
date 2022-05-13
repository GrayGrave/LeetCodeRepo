package leetcode.code;

import java.util.HashMap;
import java.util.Map;

/**
 * 无重复字符的最长子串
 * 思路：双指针 -> 滑动窗口
 */
public class lc_03 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> window = new HashMap<>();
        int res = 0;
        int l = 0, r = 0;

        while (r < s.length()) {
            char c = s.charAt(r);
            r++;

            // 进行一系列的更新
            window.put(c, window.getOrDefault(c, 0) + 1);
            //判断左窗口是否需要进行更新
            while (window.get(c) > 1) {
                char d = s.charAt(l);
                l++;
                // 进行窗口内数据的更新
                window.put(d, window.get(d) - 1);
            }

            // 更新res
            res = Math.max(res, r - l);
        }
        return res;
    }
}
