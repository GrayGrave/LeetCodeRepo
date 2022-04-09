package leetcode.code;

import java.util.*;

/**
 * 合并区间
 * 思路：区间按照起始位置排序，然后逐一扫描
 */
public class lc_56 {
    public int[][] merge(int[][] arr) {
        if (arr == null || arr.length <= 1) return arr;
        List<int[]> res = new ArrayList<>();

        // 按照区间开始位置升序排序
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        int i = 0;
        int len = arr.length;
        while (i < len) {       // 逐一扫描区间
            int left = arr[i][0];
            int right = arr[i][1];

            // 开始一个区间的合并
            while (i < len - 1 && right >= arr[i + 1][0]) {
                right = Math.max(right, arr[i + 1][1]);
                i++;
            }
            res.add(new int[]{left, right});
            i++;                 // 继续下一个区间的合并
        }
        return res.toArray(new int[res.size()][2]);
    }
}
