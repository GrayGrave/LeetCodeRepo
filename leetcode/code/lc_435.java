package leetcode.code;

import java.util.Arrays;

/**
 * 无重叠区间
 * 给定一个区间的集合intervals，其中 intervals[i] = [starti, endi]。返回需要移除区间的最小数量，使剩余区间互不重叠。
 * 思路：贪心方法  note："课程安排下最多可以上多少节课"系列问题，类似问题还有 lc_452、lc_605、lc_455、lc_253 等
 */
public class lc_435 {
    public int eraseOverlapIntervals(int[][] arr) {
        if (arr.length <= 1) return 0;
        /*
         Arrays.sort(arr,new Comparator<int[]>(){
             @Override
             public int compare(int[] a,int[] b){
                 return a[0]-b[0];
             }
         });
        */
        Arrays.sort(arr, (a, b) -> a[1] - b[1]); // 以区间末端位置进行升序

        int count = 1;                 // 最多可组成的不重叠区间
        int end = arr[0][1];
        for (int[] interval : arr) {
            if (interval[0] >= end) {
                count++;             // 找到下一个区间了
                end = interval[1];
            }
        }

        return arr.length - count;     // 最多不重叠区间的补集就是最少移除区间 👍🏻
    }
}
