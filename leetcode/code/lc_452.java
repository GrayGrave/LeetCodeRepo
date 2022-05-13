package leetcode.code;

import java.util.Arrays;

/**
 * 用最少数量的箭引爆气球
 * 有一些球形气球贴在一堵用 XY 平面表示的墙面上。墙面上的气球记录在整数数组points，其中points[i] = [xstart, xend]表示水平直径在xstart和xend之间的气球。你不知道气球的确切 y 坐标。
 * 一支弓箭可以沿着 x 轴从不同点完全垂直地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足 xstart≤ x ≤ xend，则该气球会被引爆。
 * 可以射出的弓箭的数量没有限制。弓箭一旦被射出之后，可以无限地前进。给你一个数组 points ，返回引爆所有气球所必须射出的最小弓箭数。
 * 思路：贪心方法，"课程安排下，如何上最多节课问题"，直接默写模板秒杀！
 */
public class lc_452 {
    public int findMinArrowShots(int[][] arr) {
        if (arr.length <= 1) return arr.length;
        Arrays.sort(arr, (a, b) -> a[1] - b[1]);  // 以区间末端位置进行升序

        int count = 1;                 // 最大可组成的不重叠区间 👍🏻
        int end = arr[0][1];
        for (int[] interval : arr) {
            if (interval[0] > end) {     // 边界挨着也要擦爆，所以边界挨着的不算不重叠区域，与435题(interval[0]>=end)唯一的区别在此！
                count++;                 // 找到下一个区间了
                end = interval[1];
            }
        }
        return count;
    }
}
